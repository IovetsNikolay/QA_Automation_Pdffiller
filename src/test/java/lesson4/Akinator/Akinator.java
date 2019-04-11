package lesson4.Akinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

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

        Akinator akinatorObj = new Akinator();
        Scanner scan = new Scanner(System.in);
        System.out.println("Akinator Game, lets start");
        System.out.println();
        driver.findElement(akinatorObj.playButton).click();
        for (int i = 1; true; i++) {
            System.out.println(i + ". " + driver.findElement(akinatorObj.questionText).getText());
            System.out.println();
            new FluentWait<>(driver)
                    .pollingEvery(Duration.ofMillis(100))
                    .withTimeout(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class, WebDriverException.class)
                    .until(d ->
                            driver.findElements(By.xpath("//div[@class='database-selection selector dialog-box']//ul/li")).size() == 5
                    );

            IntStream.rangeClosed(1, 5).forEach(answerNumber ->
                    new FluentWait<>(driver)
                            .pollingEvery(Duration.ofMillis(200))
                            .withTimeout(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class, WebDriverException.class)
                            .until(d -> {
                                WebElement answer = driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + answerNumber + "]"));
                                System.out.println("Answer #1:" + answer.getText());
                                return true;
                            })
            );
            System.out.println();
            System.out.print("Please enter your answer: ");
            int userInputAnswer = scan.nextInt();

            WebElement element = driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + userInputAnswer + "]"));
            new Actions(driver).moveToElement(element).perform();
            element = driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + userInputAnswer + "]/a[@class='current']"));
            element.click();
        }
//        driver.quit();
    }


}
