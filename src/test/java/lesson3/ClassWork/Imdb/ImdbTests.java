package lesson3.ClassWork.Imdb;

import lesson3.ClassWork.Imdb.AppManager.ApplicationManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class ImdbTests extends ApplicationManager {

    ApplicationManager app = new ApplicationManager();

    @BeforeSuite

    public void setup () {
        app.init();
    }

    @Test

    public void printRatedFilms () {
        List<WebElement> filmNameList = app.formArrayList(filmName);
        List<WebElement> filmRatingList = app.formArrayList(filmRating);

        app.printFilmData(filmNameList, filmRatingList);
    }

    @AfterTest

    public void afterMethod () {
        app.stop();
    }

}