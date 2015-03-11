package message.gateway.ws;

import message.gateway.ws.types.NotValidMessageException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import static message.gateway.ws.types.Constants.*;

/**
 * Created by kutepoval on 06.08.2014.
 */
public class RB extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        JaxbDataFormat jaxbSendMessageRequest = new JaxbDataFormat(true);
        jaxbSendMessageRequest.setContextPath("com.tz.schemas.message_gateway_ws");
        jaxbSendMessageRequest.setPartClass(com.tz.schemas.message_gateway_ws.SendEmailMessage.class.getName());
        jaxbSendMessageRequest.setPartNamespace("{http://schemas.tz.com/message-gateway-ws}SendEmailMessage");

        JaxbDataFormat jaxbSendMessageAsyncRequest = new JaxbDataFormat(true);
        jaxbSendMessageAsyncRequest.setContextPath("com.tz.schemas.message_gateway_ws");
        jaxbSendMessageAsyncRequest.setPartClass(com.tz.schemas.message_gateway_ws.SendEmailMessageAsync.class.getName());
        jaxbSendMessageAsyncRequest.setPartNamespace("{http://schemas.tz.com/message-gateway-ws}SendEmailMessageAsync");

        JaxbDataFormat jaxbSendMessageResponse = new JaxbDataFormat(true);
        jaxbSendMessageResponse.setContextPath("com.tz.schemas.message_gateway_ws");
        jaxbSendMessageResponse.setPartClass(com.tz.schemas.message_gateway_ws.SendMessageResponseType.class.getName());
        jaxbSendMessageResponse.setPartNamespace("{http://schemas.tz.com/message-gateway-ws}SendMessageResponseType");

        onException(NotValidMessageException.class)
                .handled(true)
                .to("log:message_not_valid?level=DEBUG&showAll=true&multiline=true")
                .to("faultResponse")
                .marshal(jaxbSendMessageResponse)
                ;

        onException(Exception.class)
                .handled(true)
                .to("log:unknown_exception?level=DEBUG&showAll=true&multiline=true")
                .to("faultResponse")
                .marshal(jaxbSendMessageResponse)
        ;

        /**
         * Ветвление по операциям
         */
        from("cxf:bean:SoapMessageGatewayService")
                .to("log:message_service_started?level=DEBUG&showAll=true&multiline=true")
                .choice()
                    .when(header("operationName").convertToString().isEqualTo(SEND_EMAIL_MESSAGE)).to("direct:SendEmailMessage")
                    .when(header("operationName").convertToString().isEqualTo(SEND_EMAIL_MESSAGE_ASYNC)).to("direct:SendEmailMessageAsync")
                    .otherwise().to("log:unknown_operation?level=DEBUG&showAll=true&multiline=true")
                .end()
        ;

        //Синхронная отправка e-mail сообщения
        from("direct:SendEmailMessage")
                .to("log:send_email_message?level=DEBUG&showAll=true&multiline=true")
                .unmarshal(jaxbSendMessageRequest)
                .setBody(simple("${body?.getMessage}"))
                .to("validator")
                .to("prepareEmailMessage")
                .to("log:before_send_mail?level=DEBUG&showAll=true&multiline=true")
                .to("MailEndpoint")
                .to("createResponse")
                .marshal(jaxbSendMessageResponse)
                ;

        //Асинхронная отправка e-mail сообщения (в очередь seda)
        from("direct:SendEmailMessageAsync")
                .to("log:send_email_message_async?level=DEBUG&showAll=true&multiline=true")
                .to("seda:emailQueue")

                ;

        //Очередь seda с 25-ю обработчиками
        from("seda:emailQueue?concurrentConsumers=25")
                .to("log:from_email_queue?level=DEBUG&showAll=true&multiline=true")
                .unmarshal(jaxbSendMessageAsyncRequest)
                .setBody(simple("${body?.getMessage}"))
                .to("validator")
                .to("prepareEmailMessage")
                .to("log:before_send_mail?level=DEBUG&showAll=true&multiline=true")
                .to("MailEndpoint")
                ;
    }
}
