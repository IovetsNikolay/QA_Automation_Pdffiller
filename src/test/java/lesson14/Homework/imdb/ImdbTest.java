package lesson14.Homework.imdb;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class ImdbTest {

    WebDriver driver;

    private String ImdbFilmPageUrl = "https://www.imdb.com/chart/top";

    private By filmUrl = By.cssSelector("td.titleColumn a");

    private List<String> filmLinkList;

    @BeforeClass
    public void init() {
        driver = new ChromeDriver();
        driver.navigate().to(ImdbFilmPageUrl);
        List<WebElement> filmWebElemList = driver.findElements(filmUrl);
        filmLinkList = new ArrayList<>();
        for (WebElement e : filmWebElemList) {
            filmLinkList.add(e.getAttribute("href"));
        }
    }

    @Test
    public void filmTest () throws IOException {
        List<String> htmlList = new ArrayList<>();
        List<FilmObject> filmObjectList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            htmlList.add(getPageHtml(filmLinkList.get(i)));
        }
        for (String s : htmlList) {
            filmObjectList.add(parseHtml(s));
        }
        filmObjectList.sort(Comparator.comparing(o -> o.year));
        System.out.println("Film sorting by Year");
        for (FilmObject o : filmObjectList) {
            System.out.println(o.name + "  " + o.year);
        }
        System.out.println();
        filmObjectList.sort(Comparator.comparing(o -> o.metascore));
        System.out.println("Film sorting by Metascore");
        for (FilmObject o : filmObjectList) {
            System.out.println(o.name + "  " + o.metascore);
        }
        System.out.println();
        filmObjectList.sort(Comparator.comparing(o -> o.leght));
        System.out.print("The shortest movie is:  ");
        System.out.println(filmObjectList.get(0).name + " " + filmObjectList.get(0).leght);
        List<DirectorObject> directorObjectList = makeDirectorObject(filmObjectList);
        directorObjectList.sort(Comparator.comparing(o -> o.filmValue));
        System.out.println();
        System.out.println("List of the directors with films quantity");
        System.out.println();
            for (DirectorObject d : directorObjectList) {
                System.out.println(d.director +  "  " + d.filmValue);
            }
        System.out.println();
        System.out.println("List of the directors with avarange rating");
        System.out.println();
            directorObjectList.sort(Comparator.comparing(o->o.avarangeValue));
            for (DirectorObject d : directorObjectList) {
                System.out.println(d.director + "  " + d.avarangeValue);
            }
        List<ActorsObject> actorsObjectList = makeActorObject(filmObjectList);
            actorsObjectList.sort(Comparator.comparing(o->o.filmValue));
        System.out.println();
        System.out.println("List of the actors with films quantity");
        System.out.println();
        for (ActorsObject d : actorsObjectList) {
            System.out.println(d.actor +  "  " + d.filmValue);
        }
        System.out.println();
        System.out.println("List of the directors with avarange rating");
        System.out.println();
        actorsObjectList.sort(Comparator.comparing(o->o.avarangeValue));
        for (ActorsObject d : actorsObjectList) {
            System.out.println(d.actor + "  " + d.avarangeValue);
        }
        System.out.println();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    public String getPageHtml(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public FilmObject parseHtml(String html) {
        Document document = Jsoup.parse(html);
        FilmObject filmObject = new FilmObject();
        filmObject.name = document.select("div.originalTitle").text();
        int nameIndex = filmObject.name.indexOf(" (");
        if (nameIndex != -1) {
            filmObject.name = filmObject.name.substring(0, nameIndex);
        }
        filmObject.rating = Double.parseDouble(document.select("span[itemprop=\"ratingValue\"]").text());
        String[] directorIndex = document.select("div.credit_summary_item a:first-of-type").text().split(" ", 3);
        filmObject.director = directorIndex[0] + " " + directorIndex[1];
        filmObject.actors =  document.select("td.primary_photo + td a").eachText();
        filmObject.ganres = document.select(".subtext .ghost + a").eachText().get(0);
        String metascore = document.select(".metacriticScore span").text();
        if (!metascore.equals("")) {
            filmObject.metascore = Integer.parseInt(metascore);
        } else {
            filmObject.metascore = 90;
        }
        filmObject.year = document.select("#titleYear a").text();
        filmObject.leght = document.select("div.txt-block time[datetime]").text();
        int leghtIndex = filmObject.leght.indexOf(" min");
        if (leghtIndex != -1) {
            filmObject.leght = filmObject.leght.substring(0, leghtIndex);
        }
        return filmObject;
    }

    public List<DirectorObject> makeDirectorObject(List<FilmObject> filmObjects) {
        List<DirectorObject> directorObjectList = new ArrayList<>();
        boolean tempVar = false;
        for (FilmObject o : filmObjects) {
            for (DirectorObject d : directorObjectList) {
                if (o.director.equals(d.director)) {
                    tempVar = true;
                    d.filmValue++;
                    d.totalRating += o.rating;
                }
            }
            if (!tempVar) {
                directorObjectList.add(new DirectorObject(o.director, o.rating));
            }
            tempVar = false;
        }
        for (DirectorObject d : directorObjectList) {
            d.avarangeValue = d.totalRating / d.filmValue;
        }
        return directorObjectList;
    }

    public List<ActorsObject> makeActorObject(List<FilmObject> filmObjects) {
        List<ActorsObject> actorObjectList = new ArrayList<>();
        boolean tempVar = false;
        for (FilmObject o : filmObjects) {
            for (String s : o.actors) {
                for (ActorsObject d : actorObjectList) {
                    if (s.equals(d.actor)) {
                        tempVar = true;
                        d.filmValue++;
                        d.totalRating += o.rating;
                    }
                }
                if (!tempVar) {
                    actorObjectList.add(new ActorsObject(s, o.rating));
                }
            }
            tempVar = false;
        }
        for (ActorsObject d : actorObjectList) {
            d.avarangeValue = d.totalRating / d.filmValue;
        }
            return actorObjectList;
    }


}
