package lesson3.ClassWork.liniakinoShowtimes.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppManager {

    public class ApplicationManager {
        WebDriver driver;

        protected String url = "http://liniakino.com/showtimes/aladdin/";

        protected By filmName1 = By.xpath("//li//h1/a");                                      //Cards of the locators

        public void init() {
            System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            //driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            //loginPage = new LoginPageHelper(driver);                                      //Transfer created driver object in LoginPageHelper class by constructor

            driver.navigate().to(url);
        }

        public void stop() {
            driver.quit();
        }

        public List<WebElement> formArrayList(By locator) {
            List<WebElement> arrayList = driver.findElements(locator);
            return arrayList;
        }

        public void printFilmData(List<WebElement> filmName) {
            for (int i = 0; i < filmName.size(); i++) {
                System.out.println(i + 1 + ". " + filmName.get(i).getText());
            }
        }
    }

}

