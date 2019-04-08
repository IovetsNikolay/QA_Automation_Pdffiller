package lesson4.Akinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Akinator {


    private By playButton = By.xpath("//a[@href='/game']/span");
    private By questionText = By.xpath("//p[@class='question-text']");
    //private By answersText = By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + answerNumber + "]");

    public static void main(String[] args) {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.navigate().to("https://ru.akinator.com/");

        int answerNumber;
        Akinator akinatorObj = new Akinator();
        Scanner scan = new Scanner(System.in);
        System.out.println("Akinator Game, lets start");
        System.out.println();
        driver.findElement(akinatorObj.playButton).click();
        int i = 0;
        for (; ; ) {
            i++;
            System.out.println(i + ". " + driver.findElement(akinatorObj.questionText).getText());
            System.out.println();
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

            driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + userInputAnswer + "]")).click();
        }
        //driver.quit();                    ??????????????????
    }
}
