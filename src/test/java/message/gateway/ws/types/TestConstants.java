package message.gateway.ws.types;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by kutepoval on 25.08.2014.
 */
public class TestConstants {

    public static final ArrayList<String> EMAIL_LIST_TRUE = new ArrayList<String>(
        Arrays.asList(
                "a@a.ru",
                "12345@gmail.com",
                "alkutepov@gmail.com",
                "alkutepov@12345gmail.com",
                "ALKutepov12345@gmail.com",
                "al.kutepov@gmail.com",
                "al-kutepov@gmail.com",
                "al_kutepov@gmail.com",
                "al.ku-te_pov@gmail.com",
                "al.ku.te.pov@gmail.com",
                "alkutepov@g.mail.com",
                "alkutepov@g-mail.com",
                "alkutepov@g_mail.com",
                "alkutepov@g.m-a_il.com",
                "alkutepov@g.m.a.il.com",
                "al.ku-te_pov@g.m-a_il.com"
        )
    );

    public static final ArrayList<String> EMAIL_LIST_FALSE = new ArrayList<String>(
            Arrays.asList(
                    "@",
                    "@gmail.com",
                    "alkutepov@",
                    "alkutepov@gmail",
                    "alkutepov@gmail-com",
                    "alkutepov@gmail_com",
                    "al kutepov@gmail.com",
                    "al-.kutepov@gmail.com",
                    "al_.kutepov@gmail.com",
                    ".kutepov@gmail.com",
                    "_kutepov@gmail.com",
                    "-kutepov@gmail.com",
                    "alkutepov@gmail.com.",
                    "alkutepov@gmail.com-",
                    "alkutepov@gmail.com_",
                    "al&kutepov@gmail.com",
                    "al@kutepov@gmail.com",
                    "al__kutepov@gmail.com",
                    "al..kutepov@gmail.com",
                    "al--kutepov@gmail.com",
                    "alkutepov@gmail..com",
                    "alkutepov@gmail-.com",
                    "alkutepov@gmail_.com",
                    "alkutepov@gmail.com12345",
                    "alkutepov@g#mail.com",
                    "alkutepov@g#mail..com"
            )
    );

    private TestConstants() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}
