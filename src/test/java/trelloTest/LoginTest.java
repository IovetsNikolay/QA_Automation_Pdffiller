package trelloTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import trello.core.BrowserFactory;
import trello.core.Pages;
import trello.pages.BoardsPage;
import trello.pages.LoginPage;


public class LoginTest extends Pages {

    private LoginPage loginPage;
    private BoardsPage boardsPage;

    @Test
    public void loginTest () {
        loginPage = new LoginPage();
        loginPage.goToLoginPage()
                .login();
    }
    @Test
    public void logoutTest() {
        boardsPage = new BoardsPage();
        boardsPage.logout();
    }
}