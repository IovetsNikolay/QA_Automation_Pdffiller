package lesson1.HomeWork.pages;

import lesson1.HomeWork.model.DataFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    protected WebDriver driver;
    protected String url = "https://www.facebook.com";
    private By loginName = By.xpath("//input[@id='email']");
    private By passwordName = By.xpath("//input[@id='pass']");
    private By loginButton = By.xpath("//input[@id='u_0_2']");
    private By messageButton = By.xpath("//div[contains(text(),'Messenger')]");
    private By messangerSelect = By.xpath("//ul[@aria-label='Conversation List']/*[1]");
    private By MassageContent = By.xpath("//div[@class='__i_']//div[@id='js_1']/*[last()]/*[1]/*[last()]/div/div/div/span");

    public void pageLogin(DataFields credentials) {
        ClearLoginField ();
        ClearPasswordField ();
        SetAccountNameIntoLoginField (credentials.getLogin());
        SetPasswordIntoPasswordField (credentials.getPassword());
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

    public void pressMessageButton () {
        driver.findElement(messageButton).click();
    }

    protected void selectMessenger () {
        driver.findElement(messangerSelect).click();
    }

    public String getMessageValue () {
        selectMessenger ();
        return driver.findElement(MassageContent).getText();
    }

    public void printMessageValue() {
        System.out.println("Message Text is:");
        System.out.println("***");
        System.out.println(getMessageValue ());
    }

    public void testMessageValue() {
        String expectedResult = "Get Started";
        testMessageText(expectedResult);
    }

    private void testMessageText(String expectedResult) {
        Assert.assertEquals(getMessageValue (), expectedResult);
    }

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    public void stop() {
        driver.quit();
    }
}
