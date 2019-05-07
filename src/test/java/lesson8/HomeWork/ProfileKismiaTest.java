package lesson8.HomeWork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileKismiaTest extends KismiaTestHelper{

    @Test
    private void changeGender() throws InterruptedException {
        driver.findElement(profileExpandIcon).click();
        driver.findElement(profileExpandButton).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://kismia.com/profile/settings");
        driver.findElement(profileButton).click();
        byte maleValue = 0;                                             //1 - for male; 2 - for female;
        if (getMaleValue(maleIcon)) {
            maleValue = 2;
        }
        if (getMaleValue(femaleIcon)) {
            maleValue = 1;
        }
        System.out.println(maleValue);
        if (maleValue == 1) {
            pressSaveMaleButton(femaleIcon);
        }
        if (maleValue == 2) {
            pressSaveMaleButton(maleIcon);
        }
        if (maleValue == 1) {
            Assert.assertTrue(getMaleValue(maleIcon));
        }
        if (maleValue == 2) {
            Assert.assertTrue(getMaleValue(femaleIcon));
        }
    }

    @Test
    private void birthDateChange() throws InterruptedException{

        return (byte)(rand.nextInt(9)+1);

    }
}