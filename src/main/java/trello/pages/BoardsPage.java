package trello.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import trello.core.Pages;

import java.util.ArrayList;
import java.util.List;

public class BoardsPage extends Pages {

    private String urlBoardsPage = "https://trello.com/mykola175/boards";

    private By userDropdown = By.xpath("//span[@class='member-initials']");
    private By logoutOptionDropdown = By.xpath("//a[@class='js-logout']");
    private By createNewDeckBlock = By.xpath("//div[@class='board-tile mod-add']");
    private By createBoardModalInput = By.xpath("//div[@class='board-tile create-board-tile has-photo-background']//div[1]/input");
    private By createBoardModalSubmitButton = By.xpath("//button[@class='primary']");
    private By favoritedBoardsTitles = By.xpath("//span[@class='icon-lg icon-star']/../../..//div[@dir='auto']");
    private By personalBoardsTitles = By.xpath("//span[@class='icon-lg icon-member']/../../..//div[@dir='auto']");
    private By favoritedBoardsElements = By.xpath("//span[@class='icon-lg icon-star']/../../..//li");
    public By personalBoardsElements = By.xpath("//span[@class='icon-lg icon-member']/../../..//li");
    private By favoriteStarIcon = By.xpath("//span[@class='icon-sm icon-star board-tile-options-star-icon']");
    private By unfavoriteStarIcon = By.xpath("//span[@class='icon-sm icon-star is-starred board-tile-options-star-icon']");



    private LoginPage loginPage;
    private ActiveBoardPage activeBoardPage;

    public By getFavoritedBoardsTitles() {
        return favoritedBoardsTitles;
    }

    public By getPersonalBoardsTitles() {
        return personalBoardsTitles;
    }

    public String getUrlBoardsPage() {
        return urlBoardsPage;
    }

    public By getCreateNewDeckBlock() {
        return createNewDeckBlock;
    }

    public LoginPage logout() {
        driver.findElement(userDropdown).click();
        driver.findElement(logoutOptionDropdown).click();
        loginPage = new LoginPage();
        Assert.assertTrue(isUrlOpened(loginPage.logoutUrl, 6));
        Assert.assertTrue(isElementPresent(loginPage.logoutHeader, 6));
        return loginPage;
    }

    public ActiveBoardPage createBoard(String createGroupName) {
        click(createNewDeckBlock);
        isElementPresent(createBoardModalInput, 6);
        driver.findElement(createBoardModalInput).clear();
        driver.findElement(createBoardModalInput).sendKeys(createGroupName);
        click(createBoardModalSubmitButton);
        activeBoardPage = new ActiveBoardPage();
        Assert.assertTrue(isElementPresent(activeBoardPage.getSidebarMenu(), 6));
        Assert.assertTrue(driver.getCurrentUrl().contains(createGroupName.toLowerCase().replaceAll(" ", "-")));
        return activeBoardPage;
    }

    public ArrayList<String> getBoardsList(By stringLocator) {
        ArrayList<String> boardsNameList = new ArrayList<>();
        List<WebElement> titleList = driver.findElements(stringLocator);
        for (WebElement e : titleList) {
            boardsNameList.add(e.getAttribute("title"));
        }
        return boardsNameList;
    }

    public void makeBoardFavorite(By sectionLocator) throws InterruptedException {
        List<WebElement> titleList = driver.findElements(sectionLocator);
        WebElement firstGroup = titleList.get(0);
        ArrayList<String> favoritesBoardsList = getBoardsList(getFavoritedBoardsTitles());
        Actions actions = new Actions(driver);
        actions.moveToElement(firstGroup).build().perform();
        click(makeConplainLocator(personalBoardsElements, favoriteStarIcon, 1));
        checkElementListSizeIncrease(favoritesBoardsList, 3);
    }

    public void makeBoardUnfavorite(By sectionLocator) {
        ArrayList<String> favoritesBoardsList = getBoardsList(getFavoritedBoardsTitles());
        click(makeConplainLocator(personalBoardsElements, unfavoriteStarIcon, 1));
        checkElementListSizeDicrease(favoritesBoardsList, 3);
    }
}
