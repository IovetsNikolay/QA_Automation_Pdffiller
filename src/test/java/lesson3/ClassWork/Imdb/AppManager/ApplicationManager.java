package lesson3.ClassWork.Imdb.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;

    protected String url = "https://www.imdb.com/chart/top";

    protected By filmName = By.xpath("//td[@class='titleColumn']/a");                  //Card of the locators
    protected By filmRating = By.xpath("//td[@class='ratingColumn imdbRating']/strong");
    //protected By filmLink = By.xpath("//tbody[@class='lister-list']/tr//strong");


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

    public void printFilmData (List<WebElement> filmName, List<WebElement> filmRating) {
        for (int i = 0; i < filmName.size(); i++) {
            System.out.println(i+1 + ". " + filmName.get(i).getText() + " Rating: " + filmRating.get(i).getText() + " Link: " + filmName.get(i).getAttribute("href"));
        }
    }
}
