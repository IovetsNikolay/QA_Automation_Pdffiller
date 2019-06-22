//package SignNow;
//
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import java.util.Card;
//    package tests.sign_now.documents;
//
//import com.products.thirdparty.testrail.TestCase;
//import com.products.thirdparty.testrail.TestRailListener;
//import core.AssertionException;
//import core.ExpectedConditions;
//import data.sign_now.Environment;
//import data.sign_now.SignNowBasicTest;
//import data.sign_now.URLs;
//import listeners.VideoListener;
//import listeners.WebTestListener;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//import pages.sign_now.ArchivePage;
//import pages.sign_now.DocumentsPage;
//import pages.sign_now.moreActions.MoreActions;
//import pages.sign_now.popups.UnArchivePopup;
//import ru.yandex.qatools.allure.annotations.Features;
//import utils.SignNowRequestMan;
//
//import java.util.Card;
//
//import static data.TestData.FilesToUpload.editorFile;
//
//    @Listeners({WebTestListener.class, VideoListener.class, TestRailListener.class})
//    @Features("ArchiveDocument")
//
//    public class ArchiveUnarchiveTests extends SignNowBasicTest {
//
//        private DocumentsPage documentsPage;
//        private ArchivePage archivePage;
//        private MoreActions moreActions;
//        private UnArchivePopup unArchivePopup;
//
//
//        @BeforeTest
//        public void preConditions() {
//            new SignNowRequestMan().uploadDocument("iovets.mykola+memb@pdffiller.team", "123456", editorFile);
//            documentsPage = autoLogin(URLs.getLoginPageURL(), "iovets.mykola+memb@pdffiller.team", "123456", DocumentsPage.class);
//            //Спросить про куки
//        }
//
//        @TestCase({930})
////    @Test
//        public void archiveTest() {
//            documentsPage.clickMore(1).deleteDocument();        //Test Preparation
//            boolean isDocumentFolderEmptyAfterArchive = documentsPage
//                    .clickMore(1)
//                    .archive()
//                    .confirmArchive().areDocumentsPresent();
//            boolean isDocumentPresentInArchiveFolder = documentsPage.openArchive().areDocumentsPresent();
//
//            SoftAssert softAssert = new SoftAssert();
//            softAssert.assertFalse(isDocumentFolderEmptyAfterArchive, "Document didn't delete from Document folder");
//            softAssert.assertTrue(isDocumentPresentInArchiveFolder, "Document didn't add to Archive folder folder");
//            softAssert.assertAll();
//        }
//
//        @Test
//        public void unarchiveTest() throws InterruptedException {
//
//            Card<String> documentsInFolderAfterUnArchive = documentsPage
//                    .openArchive()
//                    .clickMore(1)
//                    .unArchive()
//                    .confirmUnArchive()
//                    .getDocumentsNamesList();
//            boolean isArchiveFolderIsEmpty = documentsPage.openArchive().areDocumentsPresent();
//
//    }
//
//
//}
//
//
//<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
//<suite name="SignNow archive unarchive document" verbose="1">
//<parameter name="experiment" value="folder,rctapp"/>
//<parameter name="url" value="https://app-rc.signnow.com/rctapp/login"/>
//
//<test name="Archive Unarchive document">
//<classes>
//<class name="tests.sign_now.documents.ArchiveUnarchiveTests">
//<methods>
//<!--<include name="archiveTest"/>-->
//<include name="unarchiveTest"/>
//</methods>
//</class>
//</classes>
//</test>
//
//</suite>
//
//
//@Step
//public boolean areDocumentsPresent() {
//        return getNumberOfElements(documentContainer) != 0;
//        }
//
//
//private By documentContainer = By.cssSelector("li.doc-list__item");
//
//
