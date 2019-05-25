package SignNow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    public String url = "https://app.signnow.com/rctapp/login";                      //Site URL decalration

    @BeforeClass
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //loginPage = new LoginPageHelper(driver);                           //Transfer created driver object in LoginPageHelper class by constructor
        //wait = new WebDriverWait(driver, 10);
        driver.navigate().to(url);
        loginPod("iovets.mykola+offfree@pdffiller.team", "123456");
    }

    private void loginPod(String email, String password) {

        By emailInput = By.id("login");
        By passwordInput = By.id("pswd");
        By loginButton = By.xpath("//button[@class='btn btn-primary']");

        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }


    @Test
    private void documentOpenTest () throws InterruptedException {
        new WebDriverWait(driver, 20, 100)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@width='100%']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@width='100%']")));
        new WebDriverWait(driver, 20, 100)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.doc-info__title")));
        driver.findElements(By.cssSelector("div.doc-info__title")).get(0).click();
    }

    @AfterSuite
    public void stop() {
        driver.quit();
    }

}
