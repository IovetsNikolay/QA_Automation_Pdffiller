package trelloTest;

import org.testng.annotations.Test;
import trello.core.Pages;
import trello.pages.BoardsPage;
import trello.pages.LoginPage;

import java.util.ArrayList;

public class FavoriteBoardsTest extends Pages {

    private LoginPage loginPage;
    private BoardsPage boardsPage;

    @Test
    private void favoriteBoardsTest() throws InterruptedException {
        loginPage = new LoginPage();
        boardsPage = new BoardsPage();
        loginPage.goToLoginPage().login();
        ArrayList <String> personalBoardsList = boardsPage.getBoardsList(boardsPage.getPersonalBoardsTitles());
        personalBoardsList.remove(personalBoardsList.size()-1);
        System.out.println(driver.findElement(boardsPage.personalBoardsElements).toString());
        boardsPage.makeBoardFavorite(boardsPage.personalBoardsElements);
        boardsPage.makeBoardUnfavorite(boardsPage.personalBoardsElements);


    }




}
