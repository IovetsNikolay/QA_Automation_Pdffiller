package lesson3.ClassWork.Facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FaceBookRegistration {

    WebDriver driver;

    public AppManager app = new AppManager();

    public By firstNameInput = By.xpath("//input[@name='firstname']");                      //List of the locators
    public By lastNameInput = By.xpath("//input[@name='lastname']");
    public By phoneNumberInput = By.xpath("//input[@name='reg_email__']");
    public By passwodInput = By.xpath("//input[@name='reg_passwd__']");
    public By birthdayDayDropdown = By.xpath("//select[@id='day']");
    public By birthdayMounthDropdown = By.xpath("//select[@id='month']");
    public By birthdayYearDropdown = By.xpath("//select[@id='year']");
    public By sexManInput = By.xpath("//input[@name='sex'][@value='1']");
    public By sexWomanInput = By.xpath("//input[@name='sex'][@value='2']");
    public By submitButton = By.xpath("//button[@name='websubmit']");


    public String url = "https://www.facebook.com";

    @BeforeTest

    private void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //loginPage = new LoginPageHelper(driver);                           //Transfer created driver object in LoginPageHelper class by constructor

        driver.navigate().to(url);
    }

    @Test

    private void mainMethod() {

        driver.findElement(firstNameInput).sendKeys("Vasia");
        driver.findElement(lastNameInput).sendKeys("Pupkin");
        driver.findElement(phoneNumberInput).sendKeys("0956754433");
        driver.findElement(passwodInput).sendKeys("somePassword");
        Select dayDropdown = new Select(driver.findElement(birthdayDayDropdown));
        dayDropdown.selectByVisibleText("10");
        Select mounthDropdown = new Select(driver.findElement(birthdayMounthDropdown));
        mounthDropdown.selectByIndex(2);
        Select yearDropdown = new Select(driver.findElement(birthdayYearDropdown));
        yearDropdown.selectByIndex(3);
        driver.findElement(sexManInput).click();
        driver.findElement(sexWomanInput).click();
        driver.findElement(submitButton).click();

    }

    @AfterTest

    private void afterTest() {
        driver.quit();
    }

}
