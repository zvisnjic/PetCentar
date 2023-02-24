package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BasePage {
    public ChromeDriver driver;

    @FindBy (id = "ctl53_Header1_Image1")
    public WebElement petCentarLogo;

    @FindBy (id = "ctl53_Header1_SearchBox1_BtnSearch")
    public WebElement searchButton;

    @FindBy (id = "ctl53_Header1_SearchBox1_TbSearch")
    public WebElement searchInput;

    @FindBy (id = "ctl53_Header1_BasketSmall_LblBasketEmpty")
    public WebElement cartLogo;

    @FindBy (id = "ctl53_Header1_hlLogin")
    public WebElement logInIcon;

    public BasePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitUntilVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public boolean isElementPresent(WebElement webElement){
        try {
            return webElement.isDisplayed();
        } catch (final Exception e) {
            return false;
        }
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void browserRefresh (){
        driver.navigate().refresh();
    }


    public void acceptCookies (){
    WebElement acceptCookiesButton = driver.findElementById("ctl53_Header1_CookiesEuBox_btnAcceptAll");
    if (isElementPresent(acceptCookiesButton)){
        acceptCookiesButton.click();
    }
    }

}
