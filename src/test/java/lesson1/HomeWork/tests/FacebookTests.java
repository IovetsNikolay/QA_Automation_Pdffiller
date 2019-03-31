package lesson1.HomeWork.tests;

import lesson1.HomeWork.pages.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class FacebookTests {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeSuite

    public void setup () {
        app.init();
    }

    @AfterTest

    public void afterMethod () {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }
}
