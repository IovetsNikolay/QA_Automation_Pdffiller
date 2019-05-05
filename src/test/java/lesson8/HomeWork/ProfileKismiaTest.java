package lesson8.HomeWork;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileKismiaTest extends KismiaTestHelper{

    @Test
    private void mainMethod() throws InterruptedException {
        driver.findElement(profileExpandIcon).click();
        driver.findElement(profileExpandButton).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://kismia.com/profile/settings");
        byte maleValue = 0;                                             //1 - for male; 2 - for female;
        driver.findElement(profileButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 3, 100);
        maleValue = getMaleValue(maleValue, wait);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(femaleIcon)));
        driver.findElement(femaleIcon).click();
        if (driver.findElements(saveSetingsBlock).size() > 0) {
            maleValue = 1;
        }
        System.out.println(maleValue);
    }

    private byte getMaleValue(byte maleValue, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(maleIcon)));
        driver.findElement(maleIcon).click();
        if (driver.findElements(saveSetingsBlock).size() > 0) {
            maleValue = 2;
        }
        return maleValue;
    }
}