package lesson3.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BankCurrency {

    WebDriver driver;

    private String privatUrl = "https://www.privat24.ua";
    private String ukrsibtUrl = "https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/";
    private String universaltUrl = "https://www.universalbank.com.ua/";
    private String oschadtUrl = "http://www.oschadbank.ua/ua/";
    private String nbuUrl = "http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily";

    private By privatCurrency = By.xpath("(//div[@class='section-content rate'])[1]");
    private By ukrsibCurrencyBuy = By.xpath("(//span[@class='mobile-curr-name']/..)[1]");
    private By ukrsibCurrencySell = By.xpath("(//span[@class='mobile-curr-name']/..)[2]");
    private By universalCurrencyBuy = By.xpath("(//td[contains(text(),'USD')])[1]/following-sibling::*");
    private By universalCurrencySell = By.xpath("(//td[contains(text(),'USD')])[1]/following-sibling::*/following-sibling::*");
    private By oschadCurrencyBuy = By.xpath("//strong[@class='buy-USD']");
    private By oschadCurrencySell = By.xpath("//strong[@class='sell-USD']");
    private By nbuCurrency = By.xpath("//td[contains(text(),'Долар США')]/following-sibling::td");

    @BeforeTest

    private void init() {
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //loginPage = new LoginPageHelper(driver);                           //Transfer created driver object in LoginPageHelper class by constructor
    }

    @Test

    public void MainMethod() {
        driver.navigate().to(privatUrl);
        String privatCurrencyValue = driver.findElement(privatCurrency).getText();
        String privatStrArr[] = privatCurrencyValue.split(" / ");
        driver.navigate().to(ukrsibtUrl);
        String ukrsibCurrencyBuyValue = driver.findElement(ukrsibCurrencyBuy).getText();
        String ukrsibCurrencySellValue = driver.findElement(ukrsibCurrencySell).getText();
        driver.navigate().to(universaltUrl);
        String universalCurrencyBuyValue = driver.findElement(universalCurrencyBuy).getText();
        String universalCurrencySellValue = driver.findElement(universalCurrencySell).getText();
        driver.navigate().to(oschadtUrl);
        String oschadCurrencyBuyValue = driver.findElement(oschadCurrencyBuy).getText();
        String oschadCurrencySellValue = driver.findElement(oschadCurrencySell).getText();
        driver.navigate().to(nbuUrl);
        String nbuCurrencyValue = driver.findElement(nbuCurrency).getText();

        //System.out.println("privatCurrencyValue " + privatCurrencyValue);
        System.out.println("privat Buy / Sell: " + privatStrArr[0] + " / " + privatStrArr[1]);
        System.out.println("ukrsib Buy / Sell: " + ukrsibCurrencyBuyValue + " / " + ukrsibCurrencySellValue);
        System.out.println("universal Buy / Sell: " + universalCurrencyBuyValue + " / " + universalCurrencySellValue);
        System.out.println("oschad Buy / Sell: " + oschadCurrencyBuyValue + " / " + oschadCurrencySellValue);
        System.out.println("nbuCurrencyValue: " + nbuCurrencyValue);

        double privatCurrencyBuyDouble = Double.parseDouble(privatStrArr[0]);
        double privatCurrencySellDouble = Double.parseDouble(privatStrArr[1]);
        double ukrsibCurrencyBuyDouble = Double.parseDouble(ukrsibCurrencyBuyValue);
        double ukrsibCurrencySellDouble = Double.parseDouble(ukrsibCurrencySellValue);
        double universalCurrencyBuyDouble = Double.parseDouble(universalCurrencyBuyValue);
        double universalCurrencySellDouble = Double.parseDouble(universalCurrencySellValue);
        double oschadCurrencyBuyDouble = Double.parseDouble(oschadCurrencyBuyValue);
        double oschadCurrencySellDouble = Double.parseDouble(oschadCurrencySellValue);
        double nbuCurrencyDouble = (Double.parseDouble(nbuCurrencyValue)) / 100;

        List<Double> buyValues = new ArrayList<>();
        buyValues.add(privatCurrencyBuyDouble);
        buyValues.add(ukrsibCurrencyBuyDouble);
        buyValues.add(universalCurrencyBuyDouble);
        buyValues.add(oschadCurrencyBuyDouble);
        buyValues.add(nbuCurrencyDouble);

        List<Double> sellValues = new ArrayList<>();
        sellValues.add(privatCurrencySellDouble);
        sellValues.add(ukrsibCurrencySellDouble);
        sellValues.add(universalCurrencySellDouble);
        sellValues.add(oschadCurrencySellDouble);
        sellValues.add(nbuCurrencyDouble);

        double MidBuy;
        MidBuy = 0.0;
        for (Double buyCurency : buyValues) MidBuy = MidBuy + buyCurency;
        MidBuy /= buyValues.size();
        System.out.println("Mid Buy Currency: " + MidBuy);

        double MidSell;
        MidSell = 0.0;
        for (Double sellCurency : sellValues) MidSell = MidSell + sellCurency;
        MidSell /= sellValues.size();
        System.out.println("Mid Sell Currency: " + MidSell);

        int minIndexBuyValues = buyValues.indexOf(Collections.min(buyValues));
        //int maxIndexBuyValues = buyValues.indexOf(Collections.max(buyValues));
        //int minIndexSellValues = buyValues.indexOf(Collections.min(sellValues));
        int maxIndexSellValues = sellValues.indexOf(Collections.max(sellValues));

        System.out.println("minIndexBuyValues" + minIndexBuyValues);
        System.out.println("maxIndexSellValues" + maxIndexSellValues);

        switch (minIndexBuyValues) {
            case 0:
                System.out.println("Minimum currency buy value is in Privat Bank");
                break;
            case 1:
                System.out.println("Minimum currency buy value is in Ukrsib Bank");
                break;
            case 2:
                System.out.println("Minimum currency buy value is in Universal Bank");
                break;
            case 3:
                System.out.println("Minimum currency buy value is in Oschad Bank");
                break;
            case 4:
                System.out.println("Minimum currency buy value is in Nac Bank");
                break;
            default:
                break;
        }

        switch (maxIndexSellValues) {
            case 0:
                System.out.println("Maximum currency sell value is in Privat Bank");
                break;
            case 1:
                System.out.println("Maximum currency sell value is in Ukrsib Bank");
                break;
            case 2:
                System.out.println("Maximum currency sell value is in Universal Bank");
                break;
            case 3:
                System.out.println("Maximum currency sell value is in Oschad Bank");
                break;
            case 4:
                System.out.println("Maximum currency sell value is in Nac Bank");
                break;
            default:
                break;
        }

    }

    @AfterTest

    public void stop() {
        driver.quit();
    }

}
