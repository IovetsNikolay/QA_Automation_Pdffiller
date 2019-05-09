package lesson1.HomeWork.tests;

import org.testng.annotations.Test;

public class RibbonParse extends FacebookTests {

    @Test
    private void ribbonParse() {
        int poroshenkoCount = 0;
        int zelenskiiCount = 0;
        app.getMainPage().scrollPage(500);
        for (String u : app.getMainPage().parsePostTest()) {
            if (u.contains("Порош") || u.contains("Porosh")) {
                poroshenkoCount++;
            }
            if (u.contains("Зеленск") || u.contains("Zelensk")) {
                zelenskiiCount++;
            }
        }
        System.out.println("Порошенко:" + poroshenkoCount);
        System.out.println("Зеленский:" + zelenskiiCount);
    }
}
