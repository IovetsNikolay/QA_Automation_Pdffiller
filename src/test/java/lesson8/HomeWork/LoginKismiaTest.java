package lesson8.HomeWork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginKismiaTest extends KismiaTestHelper {

    @Test
    private void mainMethod() throws InterruptedException {
        driver.findElement(profileExpandIcon).click();
        driver.findElement(logoutExpandButton).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://en.kismia.com/");
        loginKismia("RISPIHALMA@DESOZ.CO", "feedwteks");
        Assert.assertTrue(driver.findElements(serverErrorMessage).size() > 0);

        loginKismia("RISPIHALMA@DESOZ.COm", "feedwte");
        Assert.assertTrue(driver.findElements(serverErrorMessage).size() > 0);

        loginKismia("RISPIHALMADESOZ.CO", "feedwteks");
        Assert.assertTrue(driver.findElements(validationErrorMessage).size() > 0);

        loginKismia("RISPIHALMA@DESOZCOM", "feedwteks");
        Assert.assertTrue(driver.findElements(validationErrorMessage).size() > 0);

        loginKismia("", "");
        Assert.assertTrue(driver.findElements(validationErrorMessage).size() > 0);

        loginKismia("RISPIHALMA@DESOZCOM", "");
        Assert.assertTrue(driver.findElements(validationErrorMessage).size() > 0);

        loginKismia("", "feedwteks");
        Assert.assertTrue(driver.findElements(validationErrorMessage).size() > 0);

    }

}