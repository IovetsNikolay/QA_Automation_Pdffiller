package lesson4.Akinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Akinator {


    private By playButton = By.xpath("//a[@href='/game']/span");
    private By questionText = By.xpath("//p[@class='question-text']");
    //private By answersText = By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + answerNumber + "]");

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://ru.akinator.com/");

        int answerNumber;
        Akinator akinatorObj = new Akinator();
        Scanner scan = new Scanner(System.in);
        System.out.println("Akinator Game, lets start");
        System.out.println();
        driver.findElement(akinatorObj.playButton).click();
        int i = 0;
        while (true) {
            i++;
            System.out.println(i + ". " + driver.findElement(akinatorObj.questionText).getText());
            System.out.println();
            if (driver.findElements(By.xpath("//div[@class='database-selection selector dialog-box']//ul/li")).size() == 5) {
                answerNumber = 1;
                System.out.println("Answer #1:" + driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + answerNumber + "]")).getText());
                answerNumber = 2;
                System.out.println("Answer #2:" + driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + answerNumber + "]")).getText());
                answerNumber = 3;
                System.out.println("Answer #3:" + driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + answerNumber + "]")).getText());
                answerNumber = 4;
                System.out.println("Answer #4:" + driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + answerNumber + "]")).getText());
                answerNumber = 5;
                System.out.println("Answer #5:" + driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + answerNumber + "]")).getText());

                System.out.println();
                System.out.print("Please enter your answer: ");
                int userInputAnswer = scan.nextInt();

                WebElement element = driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + userInputAnswer + "]"));
                new Actions(driver).moveToElement(element).perform();
                element = driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + userInputAnswer + "]/a[@class='current']"));
                element.click();
            } else Thread.sleep(5000);
        }
//        driver.quit();
    }


}
