package lesson3.ClassWork.Facebook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AppManager {
    private String url = "https://www.facebook.com";
    private By firstNameInput = By.xpath("//input[@name='firstname']");                      //List of the locators
    private By lastNameInput = By.xpath("//input[@name='lastname']");
    private By phoneNumberInput = By.xpath("//input[@name='reg_email__']");
    private By passwodInput = By.xpath("//input[@name='reg_passwd__']");
    private By birthdayDayDropdown = By.xpath("//select[@id='day']");
    private By birthdayMounthDropdown = By.xpath("//select[@id='month']");
    private By birthdayYearDropdown = By.xpath("//select[@id='year']");
    private By sexManInput = By.xpath("//input[@name='sex'][@value='1']");
    private By sexWomanInput = By.xpath("//input[@name='sex'][@value='2']");
    public By submitButton = By.xpath("//button[@name='websubmit']");


    WebDriver driver;

    protected void init() {
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //loginPage = new LoginPageHelper(driver);                           //Transfer created driver object in LoginPageHelper class by constructor

        driver.navigate().to(url);
    }

    protected void stop() {
        driver.quit();
    }


    protected void clickButton(By locator) {
        driver.findElement(locator).click();
    }

    protected void clickCheckboxes() {
        clickButton(sexManInput);
        clickButton(sexWomanInput);
    }

    protected void chooseDropDowns() {
        Select dayDropdown = new Select(driver.findElement(birthdayDayDropdown));
        dayDropdown.selectByVisibleText("10");
        Select mounthDropdown = new Select(driver.findElement(birthdayMounthDropdown));
        mounthDropdown.selectByIndex(2);
        Select yearDropdown = new Select(driver.findElement(birthdayYearDropdown));
        yearDropdown.selectByIndex(3);
    }

    protected void fillRegistrationInputs() {
        driver.findElement(firstNameInput).sendKeys("Vasia");
        driver.findElement(lastNameInput).sendKeys("Pupkin");
        driver.findElement(phoneNumberInput).sendKeys("0956754433");
        driver.findElement(passwodInput).sendKeys("somePassword");
    }


}
