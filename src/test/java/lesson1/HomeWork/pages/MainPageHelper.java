package lesson1.HomeWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageHelper extends MainHelper {

    private By messageButton = By.xpath("//div[contains(text(),'Messenger')]");

    public MainPageHelper(WebDriver driver) {
        super(driver);                                                              //Transfer driver from MainHelper constructor
    }

    public void pressMessageButton () {
        driver.findElement(messageButton).click();
    }
}
