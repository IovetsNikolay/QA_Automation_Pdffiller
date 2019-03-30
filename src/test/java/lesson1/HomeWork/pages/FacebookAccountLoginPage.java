package lesson1.HomeWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FacebookAccountLoginPage {

    public WebDriver driver;

    private By loginName = By.xpath("//input[@id='email']");
    private By passwordName = By.xpath("//input[@id='pass']");
    private By LoginButton = By.xpath("//input[@id='u_0_2']");
    private By MessageButton = By.xpath("//div[contains(text(),'Messenger')]");
    private By MassageContent = By.xpath("//span[@class='_3oh- _58nk']");
    public String url = "https://www.facebook.com";


    public void ClearLoginField () {
        driver.findElement(loginName).clear();
    }

    public void ClearPasswordField () {
        driver.findElement(passwordName).clear();
    }

    public void SetAccountNameIntoLoginField (String accountName) {
        driver.findElement(loginName).sendKeys(accountName);
    }

    public void SetPasswordIntoPasswordField (String passwordValue) {
        driver.findElement(passwordName).sendKeys(passwordValue);
    }

    public void pressLoginButton () {
        driver.findElement(LoginButton).click();
    }

    public void pressMessageButton () {
        driver.findElement(MessageButton).click();
    }

    public String getMessageValue () {
        String messageValue = driver.findElement(MassageContent).getText();
        return messageValue;
    }

    protected void testMessageText(String expectedResult) {
        Assert.assertEquals(getMessageValue (), expectedResult);
    }

    protected void printMessageValue() {
        System.out.println("Message Text is:");
        System.out.println("***");
        System.out.println(getMessageValue ());
    }
}
