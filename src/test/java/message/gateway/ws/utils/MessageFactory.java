package message.gateway.ws.utils;

import com.tz.schemas.message_gateway_ws.Body;
import com.tz.schemas.message_gateway_ws.Endpoint;
import com.tz.schemas.message_gateway_ws.Header;
import com.tz.schemas.message_gateway_ws.Message;

/**
 * Класс, который создаёт объекты типа Message
 * Created by kutepoval on 22.08.2014.
 */
public class MessageFactory {

    /**
     * @return возвращает пустой объект Message
     */
    public Message getEmptyMessage() {
        return new Message();
    }

    /**
     * @return возвращает объект Message, где message.getEndpoints().getEndpoint() == null
     */
    public Message getMessageWithNullEndpoint() {
        Message message = getEmptyMessage();
        message.setEndpoints(new Message.Endpoints());
        return message;
    }

    /**
     * @return возвращает объект Message, где message.getEndpoints().getEndpoint().isEmpty() == true
     */
    public Message getMessageWithEmptyEndpoint() {
        Message message = getMessageWithNullEndpoint();
        message.getEndpoints().getEndpoint();
        return message;
    }

    /**
     * @return возвращает объект Message, где Header == null
     */
    public Message getMessageWithNullHeader() {
        Message message = getMessageWithEmptyEndpoint();
        Endpoint endpoint = new Endpoint();
        endpoint.setAddress("alkutepov@gmail.com");
        message.getEndpoints().getEndpoint().add(endpoint);
        return message;
    }

    /**
     * @return возвращает объект Message, c пустым Header
     */
    public Message getMessageWithEmptyHeader() {
        Message message = getMessageWithNullHeader();
        Header header = new Header();
        message.setHeader(header);
        return message;
    }

    /**
     * @return возвращает объект Message, где message.getHeader().getSubject().isEmpty() == true
     */
    public Message getMessageWithEmptySubject() {
        Message message = getMessageWithEmptyHeader();
        message.getHeader().setSubject("");
        return message;
    }

    /**
     * @return возвращает объект Message, где Body == null
     */
    public Message getMessageWithNullBody(){
        Message message = getMessageWithEmptySubject();
        message.getHeader().setSubject("Hello World!");
        return message;
    }

    /**
     * @return возвращает объект Message, с пустым Body
     */
    public Message getMessageWithEmptyBody() {
        Message message = getMessageWithNullBody();
        Body body = new Body();
        message.setBody(body);
        return message;
    }

    /**
     * @return возвращает объект Message, с пустым TextMessage
     */
    public Message getMessageWithEmptyTextMessage() {
        Message message = getMessageWithEmptyBody();
        message.getBody().setTextMessage("");
        return message;
    }

    /**
     * @return возвращает полностью заполненный объект Message
     */
    public Message getFullMessage() {
        Message message = getMessageWithEmptyTextMessage();
        message.getBody().setTextMessage("Hello World!");
        return message;
    }
}
