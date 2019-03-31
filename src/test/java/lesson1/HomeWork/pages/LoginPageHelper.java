package lesson1.HomeWork.pages;

import lesson1.HomeWork.model.DataFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

public class LoginPageHelper {                      //Fields and methods executed in Facebook login page
    private WebDriver driver;
    private By loginName = By.xpath("//input[@id='email']");
    private By passwordName = By.xpath("//input[@id='pass']");
    private By loginButton = By.xpath("//input[@id='u_0_2']");

    public LoginPageHelper(WebDriver driver) {        //Constructor which get driver object
        this.driver = driver;
    }

    public void pageLogin(DataFields credentials) {             //general login method
        ClearLoginField ();
        ClearPasswordField ();
        SetAccountNameIntoLoginField (credentials.getLogin());
        SetPasswordIntoPasswordField (credentials.getPassword());
        pressLoginButton ();
    }

    //Need to Use, but How?
    protected String consoleInput (String description) {            //procedure that read String variable from user input
        System.out.println("Please enter" + description + "value:" );
        Scanner in = new Scanner(System.in);
        //System.out.println();
        return in.next();
    }

    private void ClearLoginField () {
        driver.findElement(loginName).clear();
    }

    private void ClearPasswordField () {
        driver.findElement(passwordName).clear();
    }

    private void SetAccountNameIntoLoginField (String accountName) {
        driver.findElement(loginName).sendKeys(accountName);
    }

    private void SetPasswordIntoPasswordField (String passwordValue) {
        driver.findElement(passwordName).sendKeys(passwordValue);
    }

    private void pressLoginButton () {
        driver.findElement(loginButton).click();
    }
}
