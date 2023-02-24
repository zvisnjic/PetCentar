package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Psi extends BasePage {

    @FindBy (id = "ctl52_Filter1_RptFilters_ctl00_RptFilter_ctl01_LnkFilter")
    private WebElement hranaMenuItem;

    public Psi (ChromeDriver driver){
        super(driver);
    }

    public Hrana clickOnHranaMenuItem (){
        hranaMenuItem.click();
        return new Hrana (driver);

    }

}
