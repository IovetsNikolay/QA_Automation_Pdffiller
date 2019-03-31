package lesson1.HomeWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

public class MainHelper {
    protected WebDriver driver;                                                   //Driver variable

    protected MainHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickOnElement(By locator) {                                    //Click on element method
        driver.findElement(locator).click();
    }

    protected String copyTagText(By locator) {                                      //Copy text tag element method
        return driver.findElement(locator).getText();
    }

    protected void printMessageValue(String stringToPrint) {                        //Print some String value in the console method
        System.out.println("Message Text is:");
        System.out.println("***");
        System.out.println(stringToPrint);
    }

    protected void typeStringValueIntoField(String credentials, By locator) {       //Clear input field and transfer some String value into input field method
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(credentials);
    }

    //Need to Use, but How?
    protected String consoleInput (String description) {                            //Read String variable from user input
        System.out.println("Please enter" + description + "value:" );
        Scanner in = new Scanner(System.in);
        //System.out.println();
        return in.next();
    }
}
