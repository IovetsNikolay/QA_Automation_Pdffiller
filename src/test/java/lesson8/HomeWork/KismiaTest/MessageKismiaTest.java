package lesson8.HomeWork.KismiaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MessageKismiaTest extends KismiaTestHelper {

    @Test
    private void messageSendingTest() throws InterruptedException {
        driver.findElement(messagesButton).click();
        driver.findElement(contactsListTopMessage).click();

        int sizeBefore = driver.findElements(sendedMesage).size();
        driver.findElement(mesageTextArea).clear();
        driver.findElement(mesageTextArea).sendKeys("TestMessage");
        driver.findElement(sendMesageButton).click();
        new WebDriverWait(driver, 3, 100)
                .until(d -> driver.findElements(sendedMesage).size() == sizeBefore + 1);
        if (driver.findElements(By.cssSelector("div.dialog-form")).size() > 0) {
            driver.findElement(By.cssSelector("span.close")).click();
        }
        List<WebElement> messagesList = driver.findElements(sendedMesage);
        Assert.assertEquals("Hi i'm site test bot. Please don't reply that message or blacklist this user.", messagesList.get(messagesList.size() - 1).getText());
    }
}
