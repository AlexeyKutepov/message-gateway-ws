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
     * @return true - валидный адрес, false - не валидный адрес
     */
    public boolean validateEmailAddress(String email)  {
        if (email==null || email.isEmpty()) {
            return false;
        }
        String[] splitedEmail = email.split("@");
        if (splitedEmail.length!=2) {
            return false;
        }
        String name = splitedEmail[0];
        String domain = splitedEmail[1];
        if (name.length()>0 && name.length()<=128) {
            Pattern patternName = Pattern.compile("^[a-zA-Z0-9]+(([.]|-|_){1}[a-zA-Z0-9]+)*$");
            Matcher matcherName = patternName.matcher(name);
            if (!matcherName.matches()) {
                return false;
            }
        } else {
            return false;
        }
        if (domain.length()>=3 && domain.length()<=256) {
            Pattern patternDomain = Pattern.compile("^[a-zA-Z0-9]+(([.]|-|_){1}[a-zA-Z0-9]+)*([.]{1}[a-zA-Z]+)+$");
            Matcher matcherDomain = patternDomain.matcher(domain);
            if (!matcherDomain.matches()) {
                return false;
            }
        }
        return true;
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
                if (!validateEmailAddress(endpoint.getAddress())) {
                    throw new NotValidMessageException(ERROR_TEXT_NOT_VALID_EMAIL);
                }
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
