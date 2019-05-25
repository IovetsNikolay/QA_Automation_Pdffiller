package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import trello.core.Pages;

public class ActiveBoardPage extends Pages {

    private By sidebarMenu = By.xpath("//div[@class='board-menu-tab-content']");
    private By sidebarMenuMoreButton = By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']");
    private By sidebarMenuCloseBoardButton = By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']");
    private By sidebarMenuCloseBoardConfirmationButton = By.xpath("//input[@class='js-confirm full negate']");
    private By CloseBoardConfirmationLink = By.xpath("//a[@class='quiet js-delete']");
    private By CloseBoardConfirmationModalButton = By.xpath("//input[@class='js-confirm full negate']");
    private By boardMissedMessageContainer = By.xpath("//div[@class='big-message quiet']");
    private By homeHeaderButton = By.xpath("//span[@class='header-btn-icon icon-lg icon-house light']");
    private By permitionDropdown = By.xpath("//a[@id='permission-level']");
    private By privateBoardCheckBox = By.xpath("//ul[@class='pop-over-list']/li[1]//span[@class='icon-sm icon-check']");
    private By noPermitionToAccessBoardMessageContainer = By.xpath("//div[@class='big-message quiet']");
    private By publicBoardBlock = By.xpath("//ul[@class='pop-over-list']/li[4]");
    private By publicConfirmationButton = By.xpath("//button[@class='js-submit wide primary full make-public-confirmation-button']");
    private By publicBoardCheckBox = By.xpath("//ul[@class='pop-over-list']/li[4]//span[@class='icon-sm icon-check']");
    private By permissionDropDownBlock = By.xpath("//div[@class='no-back']");

    private BoardsPage boardsPage;
    private WebDriver checkDriver;

    public By getSidebarMenu() {
        return sidebarMenu;
    }

    public BoardsPage deleteBoard() {
        click(sidebarMenuMoreButton);
        click(sidebarMenuCloseBoardButton);
        click(sidebarMenuCloseBoardConfirmationButton);
        isElementPresent(CloseBoardConfirmationLink,6);
        click(CloseBoardConfirmationLink);
        click(CloseBoardConfirmationModalButton);
        isElementPresent(boardMissedMessageContainer, 6);
        click(homeHeaderButton);
        boardsPage = new BoardsPage();
        return boardsPage;
    }

    public ActiveBoardPage checkThatBoardIsPrivate() throws InterruptedException {
        isElementActive(permitionDropdown, 6);
//        Thread.sleep(2000);
        click(permitionDropdown);
        isElementActive(permissionDropDownBlock,2);
        isElementPresent(privateBoardCheckBox, 2);
        String currentUrl = driver.getCurrentUrl();
        checkDriver = new ChromeDriver();
        checkDriver.get(currentUrl);
        isElementPresent(noPermitionToAccessBoardMessageContainer, 1);
        checkDriver.quit();
        return this;
    }

    public ActiveBoardPage checkThatBoardIsPublic() {
        if (!isElementPresent(permissionDropDownBlock,2)) {
            isElementActive(permitionDropdown, 6);
            click(permitionDropdown);
        }
        isElementPresent(publicBoardBlock,2);
        click(publicBoardBlock);
        click(publicConfirmationButton);
        click(permitionDropdown);
        isElementPresent(publicBoardCheckBox, 2);
        String currentUrl = driver.getCurrentUrl();
        checkDriver = new ChromeDriver();
        checkDriver.get(currentUrl);
        isElementPresent(sidebarMenu, 6);
        checkDriver.quit();
        return this;
    }
}
