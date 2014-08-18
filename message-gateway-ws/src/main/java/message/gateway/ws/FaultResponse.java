package message.gateway.ws;

import com.tz.schemas.message_gateway_ws.SendMessageResponseType;
import message.gateway.ws.types.NotValidMessageException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import static message.gateway.ws.types.Constants.*;

/**
 * Created by kutepoval on 12.08.2014.
 */
public class FaultResponse implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Exception exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        SendMessageResponseType responseType = new SendMessageResponseType();
        responseType.setMessage(exception.getMessage());
        if (exception instanceof NotValidMessageException) {
            responseType.setErrorCode("NotValidMessageException");
        } else {
            responseType.setErrorCode("UnknownException");
        }
        responseType.setResultCode(ERROR);
        exchange.getIn().setBody(responseType);
    }
}
