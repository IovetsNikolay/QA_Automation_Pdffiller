package lesson1.HomeWork.pages;

import lesson1.HomeWork.model.UserDataFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

public class LoginPageHelper {                                                      //Fields and methods executed in Facebook login page
    private WebDriver driver;

    private By loginName = By.xpath("//input[@id='email']");
    private By passwordName = By.xpath("//input[@id='pass']");
    private By loginButton = By.xpath("//input[@id='u_0_2']");

    public LoginPageHelper(WebDriver driver) {                                      //Constructor which get driver object
        this.driver = driver;
    }

    public void pageLogin(UserDataFields credentials) {                                 //general login method
        typeStringValueIntoField(credentials.getLogin(), loginName);                //clear and fill login input with login
        typeStringValueIntoField(credentials.getPassword(), passwordName);          //clear and fill password input with password
        clickOnElement(loginButton);                                                //click on the element
    }

    private void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    private void typeStringValueIntoField(String credentials, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(credentials);
    }

    //Need to Use, but How?
    protected String consoleInput (String description) {                            //procedure that read String variable from user input
        System.out.println("Please enter" + description + "value:" );
        Scanner in = new Scanner(System.in);
        //System.out.println();
        return in.next();
    }

}
