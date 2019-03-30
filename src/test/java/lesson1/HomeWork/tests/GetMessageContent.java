package lesson1.HomeWork.tests;

import lesson1.HomeWork.pages.FacebookAccountLoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GetMessageContent extends FacebookAccountLoginPage {
    private String login;
    private String password;

    @BeforeSuite

    public void setup () {
        //consoleInput();
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().to(url);
        this.login = "0956871283";
        this.password = "Feedwteks123";

    }

    private void consoleInput() {
        System.out.println("Please enter your Facebook login and password");
        System.out.println("***");
        System.out.println();
        System.out.println("Login: ");
        Scanner in = new Scanner(System.in);
        this.login = in.next();
        System.out.println();
        System.out.println("Password: ");
        this.password = in.next();
    }

    @Test

    public void testFacebookMessage () {
        String expectedResult = "Test123";
        ClearLoginField ();
        ClearPasswordField ();
        SetAccountNameIntoLoginField (login);
        SetPasswordIntoPasswordField (password);
        pressLoginButton ();
        pressMessageButton ();
        printMessageValue();
        testMessageText(expectedResult);

    }

    @AfterTest

    public void afterMethod () {
        driver.quit();
    }

}
