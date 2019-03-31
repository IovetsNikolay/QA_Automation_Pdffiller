package lesson1.HomeWork.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    private MessagePageHelper messagePage;                                     //Create object to delegated MessagePageHelper class
    private MainPageHelper mainPage;                                          //Create object to delegated MainPageHelper class
    private LoginPageHelper loginPage;                                        //Create object to delegated LoginPageHelper class
    protected String url = "https://www.facebook.com";

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        loginPage = new LoginPageHelper(driver);                                      //Transfer created driver object in LoginPageHelper class by constructor
        mainPage = new MainPageHelper(driver);                                      //Transfer created driver object in MainPageHelper class by constructor
        messagePage = new MessagePageHelper(driver);                                  //Transfer created driver object in MessagePageHelper class by constructor
        driver.navigate().to(url);
    }

    public void stop() {
        driver.quit();
    }

    public LoginPageHelper getLoginPage() {                                           //LoginPageHelper class getter
        return loginPage;
    }

    public MainPageHelper getMainPage() {                                             //MainPageHelper class getter
        return mainPage;
    }

    public MessagePageHelper getMessagePage() {                                       ////MessagePageHelper class getter
        return messagePage;
    }
}
