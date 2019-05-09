package lesson8.HomeWork.KismiaTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginKismiaTest extends KismiaTestHelper {

    @Test
    private void logoutTest() throws InterruptedException {
        driver.findElement(profileExpandIcon).click();
        driver.findElement(logoutExpandButton).click();
//        Assert.assertEquals(driver.getCurrentUrl(), "https://en.kismia.com/");
    }
        @Test
        private void serverErrorWrongEmailTest() throws InterruptedException {
        loginKismia("RISPIHALMA@DESOZ.CO", "feedwteks");
        Assert.assertTrue(driver.findElements(serverErrorMessage).size() > 0);
    }

    @Test
    private void serverErrorWrongPasswordTest() throws InterruptedException {
        loginKismia("RISPIHALMA@DESOZ.COm", "feedwte");
        Assert.assertTrue(driver.findElements(serverErrorMessage).size() > 0);
    }

    @Test
    private void validationErrorWrongEmail1Test() throws InterruptedException {
        loginKismia("RISPIHALMADESOZ.CO", "feedwteks");
        Assert.assertTrue(driver.findElements(validationErrorMessage).size() > 0);
    }

    @Test
    private void validationErrorWrongEmail2Test() throws InterruptedException {
        loginKismia("RISPIHALMA@DESOZCOM", "feedwteks");
        Assert.assertTrue(driver.findElements(validationErrorMessage).size() > 0);
    }

    @Test
    private void validationErrorEmptyEmailAndPaswordTest() throws InterruptedException {

        loginKismia("", "");
        Assert.assertTrue(driver.findElements(validationErrorMessage).size() > 0);
    }

    @Test
    private void validationErrorEmptyPaswordTest() throws InterruptedException {

        loginKismia("RISPIHALMA@DESOZCOM", "");
        Assert.assertTrue(driver.findElements(validationErrorMessage).size() > 0);
    }

    @Test
    private void validationErrorEmptyEmailTest() throws InterruptedException {
        loginKismia("", "feedwteks");
        Assert.assertTrue(driver.findElements(validationErrorMessage).size() > 0);

    }

}