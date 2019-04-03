package lesson3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ImdbTest {

    public WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.imdb.com/chart/top");
    }

    @Test
    public void myTest() {
        driver.getPageSource();     //получить НТМЛ код страницы
        driver.getCurrentUrl();     //получить текущий URL
        driver.getTitle();          //Получить title

    }

    @AfterTest
    public void tearDown() {
        driver.quit();              //close browser
        //driver.close();           //close tab
    }
}