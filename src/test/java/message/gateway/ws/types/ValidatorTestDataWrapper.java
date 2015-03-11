package message.gateway.ws.types;

import com.tz.schemas.message_gateway_ws.Message;

/**
 * Вспомагательный класс-обёртка
 * Created by kutepoval on 22.08.2014.
 */
public class ValidatorTestDataWrapper {
    private Message message; //Сообщение
    private String expectMessage; //Текст исключения

    public ValidatorTestDataWrapper(Message message, String expectMessage) {
        this.message = message;
        this.expectMessage = expectMessage;
    }

    public ValidatorTestDataWrapper() {
        this.message = null;
        this.expectMessage = null;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getExpectMessage() {
        return expectMessage;
    }

    public void setExpectMessage(String expectMessage) {
        this.expectMessage = expectMessage;
    }

    @Override
    public String toString() {
        return "ValidatorTestDataWrapper{" +
                "message=" + message +
                ", expectMessage='" + expectMessage + '\'' +
                '}';
    }
}
