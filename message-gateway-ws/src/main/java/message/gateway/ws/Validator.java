package message.gateway.ws;

import com.tz.schemas.message_gateway_ws.Endpoint;
import com.tz.schemas.message_gateway_ws.Message;
import message.gateway.ws.types.NotValidMessageException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import static message.gateway.ws.types.Constants.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by kutepoval on 07.08.2014.
 * Проверка входных данных на корректность
 */
public class Validator implements Processor {

    /**
     * Проверка e-mail адреса на корректность
     * @param email
     * @throws NotValidMessageException - если введён некорректный e-mail
     */
    public void validateEmailAddress(String email) throws NotValidMessageException {
        if (email==null || email.isEmpty()) {
            throw new NotValidMessageException("e-mail адрес не может быть пустой строкой");
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+(([.]|-|_)?[a-zA-Z0-9])*@[a-zA-Z0-9]+(([.]|-|_)?[a-zA-Z0-9])+$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new NotValidMessageException("Не валидный e-mail адрес");
        }
    }

    /**
     * Проверка на заполненность данных
     * @param exchange - содержит класс Message
     * @throws Exception
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        Message message = (Message) exchange.getIn().getBody();
        if (message==null) {
            throw new NotValidMessageException(ERROR_TEXT_MESSAGE_IS_NULL);
        }
        if (message.getEndpoints()==null ||
            message.getEndpoints().getEndpoint()==null ||
            message.getEndpoints().getEndpoint().isEmpty()) {
            throw new NotValidMessageException(ERROR_TEXT_ENDPOINT_IS_NULL);
        } else {
            for (Endpoint endpoint : message.getEndpoints().getEndpoint()) {
                validateEmailAddress(endpoint.getAddress());
            }
        }
        if (message.getHeader()==null ||
            message.getHeader().getSubject()==null ||
            message.getHeader().getSubject().isEmpty()) {
            throw new NotValidMessageException(ERROR_TEXT_HEADER_IS_NULL);
        }
        if (message.getBody()==null ||
            message.getBody().getTextMessage()==null ||
            message.getBody().getTextMessage().isEmpty()) {
            throw new NotValidMessageException(ERROR_TEXT_MESSAGE_TEXT_IS_NULL);
        }
    }
}
