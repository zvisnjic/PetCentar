package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Hrana extends BasePage{

    //uvodimo definisanje Web Elemenata pomocu anotacije @FindBy zbog POM modela i zato sto je nepotrebno da se svi elementi iniciraju u konstruktoru pri svakom kreiranju objekata klase
   @FindBy (xpath =  "//a[@id='ctl50_Filter1_RptFilters_ctl01_LnkFilterName']/parent::div//li[@class='filter-nav__group__btn-more']")
   private WebElement robnaMarkaVidiSveButton;

    public Hrana (ChromeDriver driver){
        super(driver);
        //ova linija koda moze da se izbrise jer smo element definsali iznad konstruktora pomocu @FindBy anotacije
//        this.robnaMarkaVidiSveButton = driver.findElementByXPath("//a[@id='ctl50_Filter1_RptFilters_ctl01_LnkFilterName']/parent::div//li[@class='filter-nav__group__btn-more']");
    }

    public void clickOnRobnaMarkaVidiSveButton (){
        scrollIntoView(robnaMarkaVidiSveButton);
        robnaMarkaVidiSveButton.click();

    }

    public WolfPack clickOnWolfPackRobnaMarka (){
        WebElement wolfPackRobnaMarka = driver.findElementByXPath("//a[contains(@title, 'WolfPack')]");
        scrollIntoView(wolfPackRobnaMarka);
        waitUntilVisible(wolfPackRobnaMarka, 3);
        wolfPackRobnaMarka.click();
        return new WolfPack(driver);
    }
}
