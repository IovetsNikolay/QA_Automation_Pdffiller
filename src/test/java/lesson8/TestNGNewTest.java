package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGNewTest {

    private WebDriver driver;
    private String expectedTitle = "Save Time Editing PDF Documents Online For Free";
    @BeforeTest
    @Test
    public void testNGNewTest () {
        driver = new ChromeDriver();
        driver.get("https://www.pdffiller.com/");
        WebElement titleElement = driver.findElement(By.xpath("//*[@class='page-title']"));
        String actualTitle = titleElement.getText();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect");
        Assert.assertTrue(actualTitle.equals(expectedTitle));
        Assert.fail("");

    }

}
