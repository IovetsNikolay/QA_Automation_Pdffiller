package lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Bing implements SearchForm {

    WebDriver driver = new ChromeDriver();

    public List<String> searchForm() {
        driver.get("https://www.bing.com/");
        driver.findElement(By.cssSelector("#sb_form_q")).clear();
        driver.findElement(By.cssSelector("#sb_form_q")).sendKeys("text");
        driver.findElement(By.cssSelector("#sb_form_q")).sendKeys(Keys.ENTER);
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/search"));
        List<String> result = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector(".b_algo h2"));
        for (WebElement element : elements) {
            result.add(element.getText());
        }
        return result;
    }
}
