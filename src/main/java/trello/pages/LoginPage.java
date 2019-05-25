package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import trello.core.BrowserFactory;
import trello.core.Pages;

public class LoginPage extends Pages {

    By userInput = By.id("user");
    By logoutHeader = By.xpath("//div[@class='global-header u-clearfix']");
    private By passwordInput = By.id("password");
    private By submitButton = By.id("login");
    private BoardsPage boardsPage;
    String logoutUrl = "https://trello.com/logged-out";

    public LoginPage goToLoginPage() {
        driver.get("https://trello.com/login");
        return this;
    }

    public BoardsPage login() {
        driver.findElement(userInput).clear();
        driver.findElement(userInput).sendKeys("trellotesttest@yopmail.com");
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys("feedwteks");
        click(submitButton);
        boardsPage = new BoardsPage();
        Assert.assertTrue(isElementPresent(boardsPage.getCreateNewDeckBlock(), 6));
        Assert.assertTrue(isUrlOpened(boardsPage.getUrlBoardsPage(), 6));
        return boardsPage;
    }
}
