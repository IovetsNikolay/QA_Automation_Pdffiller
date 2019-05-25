package lesson11;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TrelloTest {
    WebDriver driver;

    @Test

    public void testTakeScreen() throws IOException {
        driver.get("https://google.com");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("C:\\QA_Automation\\Code\\QA_Automation_Pdffiller\\Screenshot"));
    }


}
