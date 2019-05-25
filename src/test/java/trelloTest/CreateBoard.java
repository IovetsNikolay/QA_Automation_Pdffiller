package trelloTest;

import org.testng.annotations.Test;
import trello.core.Pages;
import trello.pages.ActiveBoardPage;
import trello.pages.BoardsPage;
import trello.pages.LoginPage;

public class CreateBoard extends Pages {

    private LoginPage loginPage;
    private ActiveBoardPage activeBoardPage;

    @Test
    public void CreateBoardTest() {
        loginPage = new LoginPage();
        loginPage.goToLoginPage()
                .login()
                .createBoard("Test 123");
    }

    @Test
    public void DeleteBoardTest() {
        activeBoardPage = new ActiveBoardPage();
        activeBoardPage.deleteBoard();
    }
}
