package lesson3.HomeWork.CinemaSeats;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class freeSeatsInCinema {

    WebDriver driver;

    public String url = "http://liniakino.com/showtimes/aladdin/";

    public By filmLinkDambo = By.xpath("//li[@class='showtime-movie']//a[contains(text(),'Дамбо')]/../..//div[@class='day-block showtime-day'][1]//li[1]//a");
    public By warningModal = By.xpath("//td[@class='arcticmodal-container_i2']/div[@class='window']");
    public By closeButton = By.cssSelector(".window-close");
    public By allSeats = By.xpath("//div[@id= 'hall-scheme-container']/div/div");
    public By seatsOccupied = By.xpath("//div[@id= 'hall-scheme-container']/div/div[@class = 'seat seat-occupied']");
    public By seatsReserved = By.xpath("//div[@id= 'hall-scheme-container']/div/div[@class = 'seat seat-reserved']");
    public By seatsFree = By.xpath("//div[@id= 'hall-scheme-container']/div/div[@class = 'seat seat-color1']");


    public void isElementPresent (By locator) {
        //try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            //new WebDriverWait(driver, 10).until((driver) -> driver.findElement(locator));
            //driver.findElement(locator);
            //return true;
        //} catch (TimeoutException ex) {
        //    return false;
        //}

    }

    @BeforeTest

    private void init() {
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //loginPage = new LoginPageHelper(driver);                           //Transfer created driver object in LoginPageHelper class by constructor
        //wait = new WebDriverWait(driver, 10);
        driver.navigate().to(url);
    }

    @Test

    private void mainMethod() throws InterruptedException {
        driver.findElement(filmLinkDambo).click();
        WebElement iframeElem = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(0);

        //if (isElementPresent(closeButton) == true) {
        //Thread.sleep(1500);
        //isElementPresent (closeButton);
            //driver.findElement(closeButton).click();
        //}
        /*new WebDriverWait(driver, 5)
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(closeButton));
        driver.findElement(closeButton).click();*/
        new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(100))
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class, WebDriverException.class)
                .until(d -> {
                    driver.findElement(closeButton).click();
                    return true;
                });

        List<WebElement> allSeatsList = driver.findElements(allSeats);
        List<WebElement> occupiedSeatsList = driver.findElements(seatsOccupied);
        List<WebElement> reservedSeatsList = driver.findElements(seatsReserved);
        List<WebElement> freeSeatsList = driver.findElements(seatsFree);
        int occupiedPlaces = occupiedSeatsList.size() + reservedSeatsList.size();
        System.out.println("Кол-во мест в зале: " + allSeatsList.size());
        System.out.println("Кол-во мест занятых: " + occupiedPlaces);
        System.out.println("Кол-во мест свободных: " + freeSeatsList.size());
        double occupiedPlacesToAllSeats = ((double) occupiedPlaces / allSeatsList.size())*100;
        String occupiedPlacesToAllSeatsFormat = String.format("%.2f", occupiedPlacesToAllSeats);
        double occupiedPlacesToFreeSeats = ((double) occupiedPlaces / freeSeatsList.size())*100;
        String occupiedPlacesToFreeSeatsFormat = String.format("%.2f", occupiedPlacesToFreeSeats);

        System.out.println("% Занятых мест от “всего мест в зале”: " + occupiedPlacesToAllSeatsFormat + "%");
        System.out.println("% Занятых мест от “свободных мест в зале”: " + occupiedPlacesToFreeSeatsFormat + "%");

    }

    @AfterTest

    private void stop() {
        driver.quit();
    }

}
