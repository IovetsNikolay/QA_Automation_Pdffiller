package lesson8.HomeWork.KismiaTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class ProfileKismiaTest extends KismiaTestHelper {

    @Test(enabled = true)
    private void changeGender() throws InterruptedException {
        driver.findElement(profileExpandIcon).click();
        driver.findElement(profileExpandButton).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://kismia.com/profile/settings");
        driver.findElement(profileButton).click();
        boolean maleValue = true;                                             //true - for male; false - for female;
        if (getMaleValue(maleIcon)) {                                              //Check what male is active now
            maleValue = false;
        }
        if (getMaleValue(femaleIcon)) {
            maleValue = true;
        }
        System.out.println(maleValue);
        if (maleValue) {                                                        //Press opositive male button
            pressSaveMaleButton(femaleIcon);
        }
        if (!maleValue) {
            pressSaveMaleButton(maleIcon);
        }
        if (maleValue) {                                                        //Check that opositive male is current now
            Assert.assertTrue(getMaleValue(maleIcon));
        }
        if (!maleValue) {
            Assert.assertTrue(getMaleValue(femaleIcon));
        }
    }

    @Test
    private void birthDateChange() throws InterruptedException {
        driver.findElement(profileExpandIcon).click();
        new WebDriverWait(driver, 5, 100)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(profileExpandButton)));
        driver.findElement(profileExpandButton).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://kismia.com/profile/settings");
        driver.findElement(profileButton).click();
        Random rand = new Random();
        byte dayValue = (byte) (rand.nextInt(31) + 1);
        byte mounthValue = (byte) (rand.nextInt(12));
        int yearValue = rand.nextInt(69) + 1931;
        new WebDriverWait(driver, 5, 100)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(daySelectLocator)));
        chooseDropDowns(daySelectLocator, Integer.toString(dayValue));
        chooseDropDowns(monthSelectLocator, getAllOptions(monthSelectLocator).get(mounthValue));
        chooseDropDowns(yearSelectLocator, Integer.toString(yearValue));
        new WebDriverWait(driver, 5, 100)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(saveSatingsButton)));
        driver.findElement(saveSatingsButton).click();
        Thread.sleep(500);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Integer.toString(dayValue),
                new Select(driver.findElement(daySelectLocator)).getFirstSelectedOption().getText());
        softAssert.assertEquals(getAllOptions(monthSelectLocator).get(mounthValue),
                new Select(driver.findElement(monthSelectLocator)).getFirstSelectedOption().getText());
        softAssert.assertEquals(Integer.toString(yearValue),
                new Select(driver.findElement(yearSelectLocator)).getFirstSelectedOption().getText());
        softAssert.assertAll();
    }
}