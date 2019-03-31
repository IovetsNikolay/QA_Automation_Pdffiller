package lesson1.HomeWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Scanner;

public class FacebookTests {

    protected WebDriver driver;

    private By loginName = By.xpath("//input[@id='email']");
    private By passwordName = By.xpath("//input[@id='pass']");
    private By loginButton = By.xpath("//input[@id='u_0_2']");
    private By messageButton = By.xpath("//div[contains(text(),'Messenger')]");
    private By messangerSelect = By.xpath("//ul[@aria-label='Conversation List']/*[1]");
    private By MassageContent = By.xpath("//div[@class='__i_']//div[@id='js_1']/*[last()]/*[1]/*[last()]/div/div/div/span");
    protected String url = "https://www.facebook.com";



    protected void pageLogin(String login, String password) {
        ClearLoginField ();
        ClearPasswordField ();
        SetAccountNameIntoLoginField (login);
        SetPasswordIntoPasswordField (password);
        pressLoginButton ();
    }

    //Need to Use, but How?
    protected String consoleInput (String description) {
        System.out.println("Please enter" + description + "value:" );
        Scanner in = new Scanner(System.in);
        //System.out.println();
        return in.next();
    }

    private void ClearLoginField () {
        driver.findElement(loginName).clear();
    }

    private void ClearPasswordField () {
        driver.findElement(passwordName).clear();
    }

    private void SetAccountNameIntoLoginField (String accountName) {
        driver.findElement(loginName).sendKeys(accountName);
    }

    private void SetPasswordIntoPasswordField (String passwordValue) {
        driver.findElement(passwordName).sendKeys(passwordValue);
    }

    private void pressLoginButton () {
        driver.findElement(loginButton).click();
    }

    protected void pressMessageButton () {
        driver.findElement(messageButton).click();
    }

    protected void selectMessenger () {
        driver.findElement(messangerSelect).click();
    }

    protected String getMessageValue () {
        selectMessenger ();
        return driver.findElement(MassageContent).getText();
    }

    protected void printMessageValue() {
        System.out.println("Message Text is:");
        System.out.println("***");
        System.out.println(getMessageValue ());
    }

    protected void testMessageValue() {
        String expectedResult = "Get Started";
        testMessageText(expectedResult);
    }

    private void testMessageText(String expectedResult) {
        Assert.assertEquals(getMessageValue (), expectedResult);
    }

}
