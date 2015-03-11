package message.gateway.ws.types;

/**
 * Created by kutepoval on 07.08.2014.
 */
public class NotValidMessageException extends Exception {
    public NotValidMessageException() {
    }

    public NotValidMessageException(String message) {
        super(message);
    }

    public NotValidMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidMessageException(Throwable cause) {
        super(cause);
    }

    public NotValidMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
