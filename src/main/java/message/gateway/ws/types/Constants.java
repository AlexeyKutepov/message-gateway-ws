package message.gateway.ws.types;

import javax.naming.OperationNotSupportedException;

/**
 * Created by kutepoval on 12.08.2014.
 */
public class Constants {

    //Операции
    public static final String SEND_EMAIL_MESSAGE = "SendEmailMessage";
    public static final String SEND_EMAIL_MESSAGE_ASYNC = "SendEmailMessageAsync";

    //Статусы
    public static final String OK = "OK";
    public static final String ERROR = "ERROR";

    //Сообщения об ошибках
    public static final String ERROR_TEXT_MESSAGE_IS_NULL = "Получен не корректный запрос";
    public static final String ERROR_TEXT_ENDPOINT_IS_NULL = "Не указано ни одного адреса электронной почты";
    public static final String ERROR_TEXT_HEADER_IS_NULL = "Не указана тема письма";
    public static final String ERROR_TEXT_MESSAGE_TEXT_IS_NULL = "Введите сообщение в поле TextMessage";
    public static final String ERROR_TEXT_NOT_VALID_EMAIL = "Не валидный e-mail адрес";


    private Constants() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}
