package message.gateway.ws.types;

import javax.naming.OperationNotSupportedException;

/**
 * Created by kutepoval on 12.08.2014.
 */
public class Constants {

    //Операции
    public static final String SEND_EMAIL_MESSAGE = "SendEmailMessage";
    public static final String SEND_EMAIL_MESSAGE_ASYNC = "SendEmailMessageAsync";

    public static final String OK = "OK";
    public static final String ERROR = "ERROR";


    private Constants() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}
