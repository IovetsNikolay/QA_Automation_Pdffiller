package lesson3.HomeWork.BankCurrency.ByParsing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BankCurrencyParsing {

    WebDriver driver;

    private String privatUrl = "https://www.privat24.ua";
    private String ukrsibtUrl = "https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/";
    private String universaltUrl = "https://www.universalbank.com.ua/";
    private String oschadtUrl = "http://www.oschadbank.ua/ua/";
    private String nbuUrl = "http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily";

//    private By privatCurrency = By.xpath("(//div[@class='section-content rate'])[1]");
//    private By ukrsibCurrencyBuy = By.xpath("(//span[@class='mobile-curr-name']/..)[1]");
//    private By ukrsibCurrencySell = By.xpath("(//span[@class='mobile-curr-name']/..)[2]");
//    private By universalCurrencyBuy = By.xpath("(//td[contains(text(),'USD')])[1]/following-sibling::*");
//    private By universalCurrencySell = By.xpath("(//td[contains(text(),'USD')])[1]/following-sibling::*/following-sibling::*");
//    private By oschadCurrencyBuy = By.xpath("//strong[@class='buy-USD']");
//    private By oschadCurrencySell = By.xpath("//strong[@class='sell-USD']");
//    private By nbuCurrency = By.xpath("//td[contains(text(),'Долар США')]/following-sibling::td");

    public String navigaetAndParse (String url) {
        driver.navigate().to(url);
        return driver.getPageSource();
    }

    public String [] splitParsed(String pasreString, String firstTag, String secondTag) {
        String [] str = pasreString.split(firstTag, 2);
        String [] str1 = str[1].split(secondTag, 2);
        return str1;
    }

    @BeforeTest

    private void init() {
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //loginPage = new LoginPageHelper(driver);                           //Transfer created driver object in LoginPageHelper class by constructor
    }

    @Test

    public void MainMethod() {
        String [] privatCurrencyValue = splitParsed(navigaetAndParse(privatUrl), "<div class=\"section-content rate\">", "</div>");
        String [] privatStrArr = privatCurrencyValue [0].split(" / ");

        String ukrsibParse = navigaetAndParse(ukrsibtUrl);
        String ukrsibCurrencyBuyValue = (splitParsed(ukrsibParse, "Покупка</span>", "<i"))[0];
        String ukrsibCurrencySellValue = (splitParsed(ukrsibParse, "Продажа</span>", "<i"))[0];

        String [] universalBuyStr = splitParsed(navigaetAndParse(universaltUrl), "                                     <td class=\"p-b-xs-2 p-y-1-sm\">\\n", "\\n");
        String universalCurrencyBuyValue = universalBuyStr [0].replaceAll(" ", "");
        String [] universalSellStr = splitParsed(universalBuyStr [1], "                                     <td class=\"p-b-xs-2 p-y-1-sm\">\\n", "\\n");
        String universalCurrencySellValue = universalSellStr [0].replaceAll(" ", "");

        String oschadParse = navigaetAndParse(oschadtUrl);
        String [] oschadCurrencyBuyValueTemp = splitParsed(oschadParse, "<strong class=\"buy-USD\"", "</strong>");
        String oschadCurrencyBuyValue = (splitParsed(oschadCurrencyBuyValueTemp[0], ">\\n", "\\n"))[0].replaceAll(" ", "");
        String [] oschadCurrencySellValueTemp = splitParsed(oschadParse, "<strong class=\"sell-USD\"", "</strong>");
        String oschadCurrencySellValue = (splitParsed(oschadCurrencySellValueTemp[0], ">\\n", "\\n"))[0].replaceAll(" ", "");

        String [] nbuCurrencyValueTemp = splitParsed(navigaetAndParse(nbuUrl), "<td class=\"cell\">Долар США", "</tr>");
        String nbuCurrencyValueTemp1 = (splitParsed(nbuCurrencyValueTemp [0], "c\"", "</tr>"))[0];
        String nbuCurrencyValue = (splitParsed(nbuCurrencyValueTemp1, ">", "<"))[0];

        //System.out.println("privatCurrencyValue " + privatCurrencyValue);
        System.out.println("privat Buy / Sell: " + privatStrArr[0] + " / " + privatStrArr[1]);
        System.out.println("ukrsib Buy / Sell: " + ukrsibCurrencyBuyValue + " / " + ukrsibCurrencySellValue);
        System.out.println("universal Buy / Sell: " + universalCurrencyBuyValue + " / " + universalCurrencySellValue);
        System.out.println("oschad Buy / Sell: " + oschadCurrencyBuyValue + " / " + oschadCurrencySellValue);

        double privatCurrencyBuyDouble = Double.parseDouble(privatStrArr[0]);
        double privatCurrencySellDouble = Double.parseDouble(privatStrArr[1]);
        double ukrsibCurrencyBuyDouble = Double.parseDouble(ukrsibCurrencyBuyValue);
        double ukrsibCurrencySellDouble = Double.parseDouble(ukrsibCurrencySellValue);
        double universalCurrencyBuyDouble = Double.parseDouble(universalCurrencyBuyValue);
        double universalCurrencySellDouble = Double.parseDouble(universalCurrencySellValue);
        double oschadCurrencyBuyDouble = Double.parseDouble(oschadCurrencyBuyValue);
        double oschadCurrencySellDouble = Double.parseDouble(oschadCurrencySellValue);
        double nbuCurrencyDouble = (Double.parseDouble(nbuCurrencyValue)) / 100;
        System.out.println("nbuCurrencyValue: " + nbuCurrencyDouble);

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
