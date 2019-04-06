package lesson3.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class freeSeatsInCinema {

    WebDriver driver;

    public String url = "http://liniakino.com/showtimes/aladdin/";

    public By filmLinkDambo = By.xpath("//li[@class='showtime-movie']//a[contains(text(),'Дамбо')]/../..//div[@class='day-block showtime-day'][1]//li[1]//a");
    public By closeButton = By.xpath("//div[@class= 'window-close arcticmodal-close']");
    public By allSeats = By.xpath("//div[@id= 'hall-scheme-container']/div/div");
    public By seatsOccupied = By.xpath("//div[@id= 'hall-scheme-container']/div/div[@class = 'seat seat-occupied']");
    public By seatsReserved = By.xpath("//div[@id= 'hall-scheme-container']/div/div[@class = 'seat seat-reserved']");
    public By seatsFree = By.xpath("//div[@id= 'hall-scheme-container']/div/div[@class = 'seat seat-color1']");

    @BeforeTest

    private void init () {
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

    private void mainMethod () {
        driver.findElement(filmLinkDambo).click();
        WebElement iframeElem = driver.findElement(By.cssSelector("iframe"));
        driver.switchTo().frame(iframeElem);
        driver.findElement(closeButton).click();
        List <WebElement> allSeatsList = driver.findElements(allSeats);
        List <WebElement> occupiedSeatsList = driver.findElements(seatsOccupied);
        List <WebElement> reservedSeatsList = driver.findElements(seatsReserved);
        List <WebElement> freeSeatsList = driver.findElements(seatsReserved);
        System.out.println("Кол-во мест в зале: " + allSeatsList.size());
        System.out.println("Кол-во мест занятых: " + (occupiedSeatsList.size()+reservedSeatsList.size()));
        System.out.println("Кол-во мест свободных: " + freeSeatsList.size());
        System.out.println("% Занятых мест от “всего мест в зале”: " + (occupiedSeatsList.size()+reservedSeatsList.size())/allSeatsList.size());
        System.out.println("% Занятых мест от “всего мест в зале”: " + (freeSeatsList.size()/allSeatsList.size()));

    }

    @AfterTest

    private void stop () {
        driver.quit();
    }

}
