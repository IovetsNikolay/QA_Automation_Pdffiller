package lesson3.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TheShawshankRedemption {

    WebDriver driver;

    private final String url = " https://www.imdb.com/title/tt0111161/";

    private By filmTitle = By.xpath("//*[@class='originalTitle']");
    private By filmYear = By.xpath("//*[@id='titleYear']/a");
    private By filmTime = By.xpath("(//time)[2]");
    private By filmRating = By.xpath("//span[@itemprop='ratingValue']");
    private By filmGenre = By.xpath("//div[@class='subtext']//a[1]");
    private By filmTrailerSrc = By.xpath("//img[@title='Trailer']/..");
    private By filmPosterSrc = By.xpath("//div[@class='poster']//img");
    private By filmDirector = By.xpath("//div[@class='plot_summary ']//div[2]//a");
    private By filmActors = By.xpath("//table[@class='cast_list']//tr/td[2]/a");
    private By filmMetascore = By.xpath("//div[@class='metacriticScore score_favorable titleReviewBarSubItem']/span");
    private By filmUserReview = By.xpath("//div[@class='titleReviewBarItem titleReviewbarItemBorder']//span[@class='subText']/a[1]");
    private By filmSamePictures = By.xpath("//div[@class='rec_page rec_selected']//img");

    @BeforeTest

    public void init () {
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

    public void mainTest () {

        System.out.println("Film Title: " + driver.findElement(filmTitle).getText());
        System.out.println("Film Year: " + driver.findElement(filmYear).getText());
        String str = driver.findElement(filmTime).getText();
        str = str.replaceAll("\\D+","");
        int i = Integer.parseInt(str);
        System.out.println("Film Lenght in minutes: " + i);
        System.out.println("Film Lenght in seconds: " + (i*60));
        System.out.println("Film Rating: " + driver.findElement(filmRating).getText());
        System.out.println("Film Ganre: " + driver.findElement(filmGenre).getText());
        System.out.println("Film TrailerLink: " + driver.findElement(filmTrailerSrc).getAttribute("href"));



    }

    @AfterTest

    public void stop () {
        driver.quit();
    }



}
