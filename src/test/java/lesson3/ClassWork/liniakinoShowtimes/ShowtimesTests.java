package lesson3.ClassWork.liniakinoShowtimes;

import lesson3.ClassWork.liniakinoShowtimes.AppManager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ShowtimesTests extends AppManager {

    ApplicationManager app = new ApplicationManager();

    @BeforeTest

    private void beforeTest () {
        app.init();
    }

    @Test

    public void outputCinemaShowTime () {

        List<WebElement> filmNameList = app.formArrayList(By.xpath("//li//h1/a"));
        app.printFilmData(filmNameList);

    }

    @AfterTest

    private void afterTest () {
        app.stop();
    }
}
