package lesson8.ClassWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNGTest {

    static WebDriver driver;
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://seleniumjava.com/2016/04/05/the-beginners-guide-to-explicit-waits/");
    }

}
