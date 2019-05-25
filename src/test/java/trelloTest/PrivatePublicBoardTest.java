package trelloTest;

import org.testng.annotations.Test;
import trello.core.Pages;
import trello.pages.LoginPage;

public class PrivatePublicBoardTest extends Pages {
    private LoginPage loginPage;

    @Test
    private void privateBoardTest   () throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.goToLoginPage()
                .login()
                .createBoard("Private Test")
                .checkThatBoardIsPrivate()
                .checkThatBoardIsPublic();
    }
}
