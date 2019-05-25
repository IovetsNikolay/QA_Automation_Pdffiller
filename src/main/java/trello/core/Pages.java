package trello.core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class Pages extends BrowserFactory {

    public boolean isElementPresent (By locator, long seconds) {
        Wait wait = new FluentWait(driver)
                .withTimeout(ofSeconds(seconds))
                .pollingEvery(ofMillis(500))
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void click(By locator) {
        Wait wait = new FluentWait(driver)
                .withTimeout(ofSeconds(15))
                .pollingEvery(ofMillis(500))
                .ignoring(ElementNotVisibleException.class).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
    }


    public boolean isUrlOpened (String url, long seconds) {
        Wait wait = new FluentWait(driver)
                .withTimeout(ofSeconds(seconds))
                .pollingEvery(ofMillis(500))
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
        try {
            wait.until(ExpectedConditions.urlToBe(url));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementActive (By locator, long seconds) {
        Wait wait = new FluentWait(driver)
                .withTimeout(ofSeconds(seconds))
                .pollingEvery(ofMillis(500))
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public By makeConplainLocator (By firstXpathLocator, By secondXpathLocator, int GroupNumber) {
        String[] array1 = firstXpathLocator.toString().split("xpath: ", 2);
        String[] array2 = secondXpathLocator.toString().split("xpath: ", 2);
        return By.xpath("(" + array1[1] + array2[1] + ")[" + GroupNumber + "]");
    }

    public boolean checkElementListSizeIncrease (ArrayList<String> webElementList, int seconds) {
        int sizeBefore = webElementList.size();
        Wait wait = new FluentWait(driver)
                .withTimeout(ofSeconds(seconds))
                .pollingEvery(ofMillis(500))
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
        try {
            wait.until(d -> webElementList.size() == sizeBefore + 1);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean checkElementListSizeDicrease (ArrayList<String> webElementList, int seconds) {
        int sizeBefore = webElementList.size();
        Wait wait = new FluentWait(driver)
                .withTimeout(ofSeconds(seconds))
                .pollingEvery(ofMillis(500))
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
        try {
            wait.until(d -> webElementList.size() == sizeBefore - 1);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}
