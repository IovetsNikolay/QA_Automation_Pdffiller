package lesson1.HomeWork.tests;

import lesson1.HomeWork.model.TestDataFields;
import lesson1.HomeWork.model.UserDataFields;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetMessageContent extends FacebookTests {

    @Test

    public void testFacebookMessage () {
        TestDataFields testData = new TestDataFields("Get Started");
        app.getMainPage().pressMessageButton();
        app.getMessagePage().printMessageValue(app.getMessagePage().getMessageValue());
        Assert.assertEquals(testData.getMessageTextValue(), app.getMessagePage().getMessageValue());
    }

}
