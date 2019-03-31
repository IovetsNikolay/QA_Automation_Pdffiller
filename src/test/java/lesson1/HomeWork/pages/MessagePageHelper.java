package lesson1.HomeWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MessagePageHelper {
    private WebDriver driver;                                                   //Driver variable
    private By messengerSelect = By.xpath("//ul[@aria-label='Conversation List']/*[1]");
    private By MassageContent = By.xpath("//div[@class='__i_']//div[@id='js_1']/*[last()]/*[1]/*[last()]/div/div/div/span");

    public MessagePageHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void selectMessenger () {
        driver.findElement(messengerSelect).click();
    }

    public String getMessageValue () {
        selectMessenger ();
        return driver.findElement(MassageContent).getText();
    }

    public void printMessageValue() {
        System.out.println("Message Text is:");
        System.out.println("***");
        System.out.println(getMessageValue ());
    }

    public void testMessageValue() {
        String expectedResult = "Get Started";
        testMessageText(expectedResult);
    }

    private void testMessageText(String expectedResult) {
        Assert.assertEquals(getMessageValue (), expectedResult);
    }
}
