package message.gateway.ws;

import com.tz.schemas.message_gateway_ws.Message;
import message.gateway.ws.types.NotValidMessageException;
import message.gateway.ws.types.ValidatorTestDataWrapper;
import message.gateway.ws.utils.MessageFactory;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static message.gateway.ws.types.Constants.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static message.gateway.ws.types.TestConstants.*;



/**
 * Created by kutepoval on 21.08.2014.
 */
@RunWith(Theories.class)
public class ValidatorTest {
    private Validator validator;
    private DefaultExchange defaultExchange;
    MessageFactory messageFactory;
    private static List<ValidatorTestDataWrapper> dataList;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        validator = new Validator();
        defaultExchange = new DefaultExchange(new DefaultCamelContext());
        messageFactory = new MessageFactory();

        dataList = new ArrayList<ValidatorTestDataWrapper>();
        dataList.add(new ValidatorTestDataWrapper(null, ERROR_TEXT_MESSAGE_IS_NULL));
        dataList.add(new ValidatorTestDataWrapper(messageFactory.getEmptyMessage(), ERROR_TEXT_ENDPOINT_IS_NULL));
        dataList.add(new ValidatorTestDataWrapper(messageFactory.getMessageWithNullEndpoint(), ERROR_TEXT_ENDPOINT_IS_NULL));
        dataList.add(new ValidatorTestDataWrapper(messageFactory.getMessageWithEmptyEndpoint(), ERROR_TEXT_ENDPOINT_IS_NULL));
        dataList.add(new ValidatorTestDataWrapper(messageFactory.getMessageWithNullHeader(), ERROR_TEXT_HEADER_IS_NULL));
        dataList.add(new ValidatorTestDataWrapper(messageFactory.getMessageWithEmptyHeader(), ERROR_TEXT_HEADER_IS_NULL));
        dataList.add(new ValidatorTestDataWrapper(messageFactory.getMessageWithEmptySubject(), ERROR_TEXT_HEADER_IS_NULL));
        dataList.add(new ValidatorTestDataWrapper(messageFactory.getMessageWithNullBody(), ERROR_TEXT_MESSAGE_TEXT_IS_NULL));
        dataList.add(new ValidatorTestDataWrapper(messageFactory.getMessageWithEmptyBody(), ERROR_TEXT_MESSAGE_TEXT_IS_NULL));
        dataList.add(new ValidatorTestDataWrapper(messageFactory.getMessageWithEmptyTextMessage(), ERROR_TEXT_MESSAGE_TEXT_IS_NULL));
    }

    @DataPoints
    public static Object[] getTestData() {
        return dataList.toArray();
    }

    @Theory
    public void testProcessExceptions(final Object testData) throws Exception {
        Message message = ((ValidatorTestDataWrapper)testData).getMessage();
        defaultExchange.getIn().setBody(message);
        thrown.expect(NotValidMessageException.class);
        thrown.expectMessage(((ValidatorTestDataWrapper)testData).getExpectMessage());
        validator.process(defaultExchange);
    }

    @Test
    public void testProcessIsCorrect() {
        Message message = messageFactory.getFullMessage();
        defaultExchange.getIn().setBody(message);
        try {
            validator.process(defaultExchange);
        } catch (Exception e) {
            fail("Класс Validator работает не корректно: "+e);
        }
    }

    @Test
    public void testValidateEmailAddress() throws Exception {
        for (String item : EMAIL_LIST_TRUE) {
            assertTrue(
                    "Не корректная работа метода validateEmailAddress(). Входные данные: "+item+" (валидный адрес). Результат: false",
                    validator.validateEmailAddress(item)
            );
        }
        for (String item : EMAIL_LIST_FALSE) {
            assertFalse(
                    "Не корректная работа метода validateEmailAddress(). Входные данные: "+item+" (невалидный адрес). Результат: true",
                    validator.validateEmailAddress(item)
            );
        }
    }


}

