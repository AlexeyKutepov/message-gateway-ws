package message.gateway.ws;

import com.tz.schemas.message_gateway_ws.SendMessageResponseType;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import static message.gateway.ws.types.Constants.*;

/**
 * Created by kutepoval on 13.08.2014.
 */
public class CreateResponse implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        SendMessageResponseType responseType = new SendMessageResponseType();
        responseType.setMessage("Сообщение отправлено");
        responseType.setResultCode(OK);
        exchange.getIn().setBody(responseType);
    }
}
