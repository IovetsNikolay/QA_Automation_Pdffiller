package lesson1.HomeWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageHelper {
    private WebDriver driver;                                                   //Driver variable
    private By messageButton = By.xpath("//div[contains(text(),'Messenger')]");

    public MainPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void pressMessageButton () {
        driver.findElement(messageButton).click();
    }
}
