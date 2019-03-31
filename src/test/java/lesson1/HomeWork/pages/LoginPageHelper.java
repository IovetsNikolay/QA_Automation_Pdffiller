package lesson1.HomeWork.pages;

import lesson1.HomeWork.model.UserDataFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageHelper extends MainHelper{                                                      //Fields and methods executed in Facebook login page
    private By loginName = By.xpath("//input[@id='email']");
    private By passwordName = By.xpath("//input[@id='pass']");
    private By loginButton = By.xpath("//input[@id='u_0_2']");

    public LoginPageHelper(WebDriver driver) {                                      //Constructor which get driver object
        super (driver);                                                             //Transfer driver from MainHelper constructor
    }

    public void pageLogin(UserDataFields credentials) {                              //general login method
        typeStringValueIntoField(credentials.getLogin(), loginName);                //clear and fill login input with login
        typeStringValueIntoField(credentials.getPassword(), passwordName);          //clear and fill password input with password
        clickOnElement(loginButton);                                                //click on the element
    }

}
