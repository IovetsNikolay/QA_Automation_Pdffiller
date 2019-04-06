package lesson3.ClassWork.Facebook;

import lesson3.ClassWork.Facebook.appmanager.AppManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FaceBookRegistration extends AppManager {


    @BeforeTest

    private void beforeTest() {
        init();
    }

    @Test

    private void mainMethod() {

        fillRegistrationInputs();
        chooseDropDowns();
        clickCheckboxes();
        clickButton(submitButton);

    }

    @AfterTest

    private void afterTest() {
        stop();
    }

}
