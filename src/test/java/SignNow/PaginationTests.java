//package SignNow;
//
//import com.products.thirdparty.testrail.TestCase;
//import com.products.thirdparty.testrail.TestRailListener;
//import data.sign_now.Environment;
//import data.sign_now.SignNowBasicTest;
//import data.sign_now.URLs;
//import listeners.VideoListener;
//import listeners.WebTestListener;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//import pages.sign_now.DocumentsPage;
//import ru.yandex.qatools.allure.annotations.Features;
//import utils.SignNowRequestMan;
//
//import static data.TestData.FilesToUpload.editorFile;
//
//@Listeners({WebTestListener.class, VideoListener.class, TestRailListener.class})
//@Features("DocumentFolderPagination")
//
//public class PaginationTests extends SignNowBasicTest {
//
//    public DocumentsPage documentsPage;
//
//    @BeforeTest
//    public void setUp() {
//        environment = Environment.SIGN_NOW_PROD;
//        String email = registerUserViaDB();
//        for (int i = 0; i < 21; i++) {
//            new SignNowRequestMan().uploadDocument(email, DEFAULT_PASSWORD, editorFile);
//        }
//        documentsPage = autoLogin(URLs.getLoginPageURL(), email, DocumentsPage.class);
//    }
//
//    @TestCase({9723})
//    @Test
//    public void paginationTest() {
//        Assert.assertTrue(documentsPage.isPaginationPresent());
//        Assert.assertTrue(documentsPage.isPreviousPaginationButtonDisabled());
//        Assert.assertTrue(documentsPage.isPaginationTextCorrectFewPages(21));
//
//        documentsPage.openPaginationPage(2);
//        Assert.assertTrue(documentsPage.checkUrlAfterPagination(2));
//        Assert.assertTrue(documentsPage.isPaginationPresent());
//        Assert.assertTrue(documentsPage.isNextPaginationButtonDisabled());
//        Assert.assertTrue(documentsPage.isPaginationTextCorrectFewPages(21));
//
//        documentsPage.openPaginationPage(1);
//        Assert.assertTrue(documentsPage.checkUrlAfterPagination(1));
//        Assert.assertTrue(documentsPage.isPaginationPresent());
//        Assert.assertTrue(documentsPage.isPreviousPaginationButtonDisabled());
//        Assert.assertTrue(documentsPage.isPaginationTextCorrectFewPages(21));
//
//        documentsPage.paginationNext();
//        Assert.assertTrue(documentsPage.checkUrlAfterPagination(2));
//        Assert.assertTrue(documentsPage.isPaginationPresent());
//        Assert.assertTrue(documentsPage.isNextPaginationButtonDisabled());
//        Assert.assertTrue(documentsPage.isPaginationTextCorrectFewPages(21));
//
//        documentsPage.clickAscendingDescendingButton();
//        Assert.assertTrue(documentsPage.checkUrlAfterPagination(1));
//        Assert.assertTrue(documentsPage.isPaginationPresent());
//        Assert.assertTrue(documentsPage.isPreviousPaginationButtonDisabled());
//        Assert.assertTrue(documentsPage.isPaginationTextCorrectFewPages(21));
//
//        documentsPage.paginationNext();
//        documentsPage.clickMore(1).deleteDocument().confirmDelete();
//        Assert.assertTrue(documentsPage.checkUrlAfterPagination(1));
//        Assert.assertTrue(documentsPage.isPaginationTextCorrectFewPages(20));
//    }
//}
//
//    @Step
//    public boolean isPaginationTextCorrectFewPages(int documentInFolderQuantity) {
//        if (documentInFolderQuantity < 21) {
//            List<WebElement> documentsList = driver.findElements(documentContainer);
//            return driver.findElement(paginationCounter).getText()
//                    .equals("1 — " + documentsList.size() + " of " + documentsList.size());                                                 //Check right displaying of the pagination text when there are less that 21 documents in folder
//        } else {
//            List<WebElement> paginationBtnContainers = driver.findElements(btnPaginationPageElements);                                      //List of the pagination buttons
//            int lastPaginationPageNumber = Integer.parseInt(paginationBtnContainers.get(paginationBtnContainers.size() - 2).getText());     //define of the last page number
//            boolean isCurrentPageLast = defineActivePaginationPage() == lastPaginationPageNumber;                                           //define is page last
//            int paginationPageCounter = ((defineActivePaginationPage() - 1) * 20) + 1;                                                      //according to last page or not define page counter
//            if (isCurrentPageLast) {
//                return driver.findElement(paginationCounter).getText()
//                        .equals(paginationPageCounter + " — " + paginationPageCounter + " of " + documentInFolderQuantity);                 //Check right displaying of the pagination text in last page in folder
//            } else {
//                return driver.findElement(paginationCounter).getText()
//                        .equals(paginationPageCounter + " — " + (paginationPageCounter + 19) + " of " + documentInFolderQuantity);          //Check right displaying of the pagination text in not last page in folder
//            }
//        }
//    }
//
//    @Step
//    public boolean checkUrlAfterPagination(int pageNumber) {
//        String[] pageUrl = driver.getCurrentUrl().split("page=", 2);
//        return (Character.getNumericValue((pageUrl[1].toCharArray())[0]) == pageNumber);
//    }
//
//    @Step
//    public int defineActivePaginationPage() {
//        return Integer.parseInt(driver.findElement(activePaginationPage).getText());
//    }
//
//    private By paginationCounter = By.xpath("//div[@class='dch-info__cell']");
//    private By activePaginationPage = By.xpath("//div[contains(@data-autotest,'dch-info__pagination__block')]//li[@class='active']/a");
//    private By btnPaginationPageElements = By.xpath("//ul[@class='dch-info__pagination pagination']//li/a");
