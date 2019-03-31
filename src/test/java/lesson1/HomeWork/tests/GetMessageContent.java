package lesson1.HomeWork.tests;

import lesson1.HomeWork.pages.FacebookTests;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GetMessageContent extends FacebookTests {

    @BeforeSuite

    public void setup () {
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().to(url);

    }

    @Test

    public void testFacebookMessage () {

        pageLogin("6572071413", "s1gngr0w");
        pressMessageButton ();
        getMessageValue ();
        printMessageValue ();
        testMessageValue();

    }
    @AfterTest

    public void afterMethod () {
        driver.quit();
    }

}
