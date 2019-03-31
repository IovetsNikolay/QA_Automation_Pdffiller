package lesson1.HomeWork.tests;

import lesson1.HomeWork.model.DataFields;
import org.testng.annotations.Test;

public class GetMessageContent extends FacebookTests {

    @Test

    public void testFacebookMessage () {

        DataFields testUser = new DataFields("6572071413", "s1gngr0w");
        app.pageLogin(testUser);
        app.pressMessageButton();
        app.getMessageValue();
        app.printMessageValue();
        app.testMessageValue();

    }

}
