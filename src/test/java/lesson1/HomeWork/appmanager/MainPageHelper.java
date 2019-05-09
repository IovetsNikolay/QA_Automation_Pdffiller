package lesson1.HomeWork.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPageHelper extends MainHelper {

    private By messageButton = By.xpath("//div[contains(text(),'Messenger')]");

    public MainPageHelper(WebDriver driver) {
        super(driver);                                                              //Transfer driver from MainHelper constructor
    }

    public void pressMessageButton () {
        driver.findElement(messageButton).click();
    }

    public ArrayList<String> parsePostTest () {
        List<WebElement> postList = driver.findElements(By.xpath("//div[@data-testid='post_message']"));
        ArrayList<String> strArr = new ArrayList<>();

        for (int i = 0; i < postList.size()-2; i++) {
            if (postList.get(i).getAttribute("outerHTML") != null) {
                strArr.add(postList.get(i).getAttribute("outerHTML"));
            }
        }
        return strArr;
    }

    public void scrollPage (int i) {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        for (int j = 0; j < i; j++) {
            jsx.executeScript("window.scrollBy(0,4000)", "");
        }
    }
}
