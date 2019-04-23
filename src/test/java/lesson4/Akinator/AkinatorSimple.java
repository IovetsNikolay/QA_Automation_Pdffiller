package lesson4.Akinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AkinatorSimple {

    private By playButton = By.xpath("//a[@href='/game']/span");
    private By questionText = By.xpath("//p[@class='question-text']");
    private By questionNumberText = By.xpath("//p[@class='question-number']");
    private By answersText = By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)");
    private By proposeBuble = By.xpath("//div[@class='bubble-propose bubble']");
    private By proposeTitle = By.xpath("//span[@class='proposal-title']");
    private By proposeYes = By.xpath("//a[@id='a_propose_yes']");
    private By proposeNo = By.xpath("//a[@id='a_propose_no']");

    public static void main(String[] args) {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://ru.akinator.com/");

        AkinatorSimple akinatorObj = new AkinatorSimple();
        Scanner scan = new Scanner(System.in);
        System.out.println("Akinator Game, lets start");
        System.out.println();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait
        driver.findElement(akinatorObj.playButton).click();
        for (int i = 1; true; i++) {
            String iStr = String.valueOf(i);
            new FluentWait<>(driver)                                            //Check question number
                    .pollingEvery(Duration.ofMillis(100))
                    .withTimeout(Duration.ofSeconds(5))
                    .until(ExpectedConditions.textToBePresentInElementLocated(akinatorObj.questionNumberText, iStr));
            //wait.until(ExpectedConditions.textToBePresentInElementLocated(akinatorObj.questionNumberText, iStr));


            //.until(driver.findElement(By.xpath(driver.findElement(akinatorObj.questionText).getText())
            //                .equals(previuosQuestionText));

            //.until(driver.findElement(By.xpath(driver.findElement(akinatorObj.questionText).getText())))

            //new FluentWait<>(driver)
            // .pollingEvery(Duration.ofMillis(100))
            //.withTimeout(Duration.ofSeconds(5))
            //.until(
            //String previuosQuestionText1 = previuosQuestionText;
            //String questionText = driver.findElement(akinatorObj.questionText).getText();
            //if (isQuestioStringEquals) {
            //  System.out.println("returnString");
            //} else {

            //}
            //)

            //      d -> {

            //if (questionText.equals(previuosQuestionText1)) {
            //  return(questionText);
            //}
            //});
            String questionNumberValue = driver.findElement(akinatorObj.questionNumberText).getText();
            String questionValue = driver.findElement(akinatorObj.questionText).getText();
            System.out.println(questionNumberValue + ". " + questionValue);

            System.out.println();
            List<WebElement> titles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(akinatorObj.answersText));
            int k = 1;
            for (WebElement elem : titles) {
                System.out.println(k + ". " + elem.getText());
                k++;
            }
                /*
                new FluentWait<>(driver)
                        .pollingEvery(Duration.ofMillis(100))
                        .withTimeout(Duration.ofSeconds(5))
                        .ignoreAll(Arrays.asList(NoSuchElementException.class, WebDriverException.class))
                        .until(d ->
                                driver.findElements(By.xpath("//div[@class='database-selection selector dialog-box']//ul/li")).size() == 5
                        );*/
            //IntStream.rangeClosed(1, 5).forEach(answerNumber ->
                    /*for (int j = 0; i < 5; i++) {
                        new FluentWait<>(driver)
                                .pollingEvery(Duration.ofMillis(200))
                                .withTimeout(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class, WebDriverException.class)
                                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + j + "]")));

                //  d -> {
                //WebElement answer = driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + answerNumber + "]"));
                //System.out.println("Answer #" + answerNumber + " :" + answer.getText());            //Здесь избыточная проверка??
                //return true;
                //})
                    }*/
            System.out.println();
            System.out.print("Please enter your answer: ");
            int userInputAnswer = scan.nextInt();

            WebElement element = driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + userInputAnswer + "]"));
            new Actions(driver).moveToElement(element).perform();
            element = driver.findElement(By.xpath("(//div[@class='database-selection selector dialog-box']//ul/li)[" + userInputAnswer + "]/a[@class='current']"));
            new FluentWait<>(driver)
                    .pollingEvery(Duration.ofMillis(100))
                    .withTimeout(Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            if (driver.findElements(akinatorObj.proposeBuble).size() > 0) {
                System.out.println("I think this: " + driver.findElement(akinatorObj.proposeTitle).getText());
                System.out.println("Am I right?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Enter your answer: ");
                byte gameFinishUserAnswer = scan.nextByte();
                if (gameFinishUserAnswer == 1) {
                    WebElement yesElement = driver.findElement(akinatorObj.proposeYes);
                    new FluentWait<>(driver)
                            .pollingEvery(Duration.ofMillis(100))
                            .withTimeout(Duration.ofSeconds(5))
                            .until(ExpectedConditions.elementToBeClickable(yesElement));
                    yesElement.click();
                    break;
                } else {
                    WebElement noElement = driver.findElement(akinatorObj.proposeNo);
                    new FluentWait<>(driver)
                            .pollingEvery(Duration.ofMillis(100))
                            .withTimeout(Duration.ofSeconds(5))
                            .until(ExpectedConditions.elementToBeClickable(noElement));
                    noElement.click();
                }
            }
        }

        driver.quit();
    }
}