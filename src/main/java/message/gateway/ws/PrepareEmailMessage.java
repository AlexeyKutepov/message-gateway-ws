package message.gateway.ws;

import com.tz.schemas.message_gateway_ws.Message;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Формируем сообщение для отправки
 * Created by kutepoval on 12.08.2014.
 */
public class PrepareEmailMessage implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Message message = (Message) exchange.getIn().getBody();
        exchange.getOut().setHeader("Subject", message.getHeader().getSubject());
        exchange.getOut().setHeader("To", message.getEndpoints().getEndpoint().get(0).getAddress());
        exchange.getOut().setHeader("Content-Type", "text/html;charset=UTF-8");
        exchange.getOut().setBody(message.getBody().getTextMessage());
    }
}
