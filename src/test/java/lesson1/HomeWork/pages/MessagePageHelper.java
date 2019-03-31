package lesson1.HomeWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagePageHelper extends MainHelper{
    private By messengerSelect = By.xpath("//ul[@aria-label='Conversation List']/*[1]");
    private By MassageContent = By.xpath("//div[@class='__i_']//div[@id='js_1']/*[last()]/*[1]/*[last()]/div/div/div/span");

    public MessagePageHelper(WebDriver driver) {
        super(driver);                                                                  //Transfer driver from MainHelper constructor
    }

    protected void selectMessenger () {
        clickOnElement(messengerSelect);
    }

    public String getMessageValue () {
        selectMessenger ();
        return copyTagText(MassageContent);
    }

}
