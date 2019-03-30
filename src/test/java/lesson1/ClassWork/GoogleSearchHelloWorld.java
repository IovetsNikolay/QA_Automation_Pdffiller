package lesson1.ClassWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchHelloWorld {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@title='Поиск']")).clear();
        driver.findElement(By.xpath("//input[@title='Поиск']")).sendKeys("HelloWorld");
        driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Поиск в Google']")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".g h3")).click();
        System.out.println(driver.getTitle());

        driver.quit();

    }
}