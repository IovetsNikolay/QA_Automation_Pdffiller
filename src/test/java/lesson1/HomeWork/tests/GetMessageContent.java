package lesson1.HomeWork.tests;

import lesson1.HomeWork.model.DataFields;
import org.testng.annotations.Test;

public class GetMessageContent extends FacebookTests {

    @Test

    public void testFacebookMessage () {

        DataFields testUser = new DataFields("6572071413", "s1gngr0w");
        app.getLoginPage().pageLogin(testUser);
        app.getMainPage().pressMessageButton();
        app.getMessagePage().getMessageValue();
        app.getMessagePage().printMessageValue();
        app.getMessagePage().testMessageValue();

    }

}
