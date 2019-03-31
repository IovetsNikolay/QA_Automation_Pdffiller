package lesson1.HomeWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagePageHelper {
    private WebDriver driver;                                                   //Driver variable
    private By messengerSelect = By.xpath("//ul[@aria-label='Conversation List']/*[1]");
    private By MassageContent = By.xpath("//div[@class='__i_']//div[@id='js_1']/*[last()]/*[1]/*[last()]/div/div/div/span");

    public MessagePageHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void selectMessenger () {
        clickOnElement(messengerSelect);
    }

    private void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    public String getMessageValue () {
        selectMessenger ();
        return getTagText(MassageContent);
    }

    private String getTagText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void printMessageValue(String stringToPrint) {
        System.out.println("Message Text is:");
        System.out.println("***");
        System.out.println(stringToPrint);
    }

}
