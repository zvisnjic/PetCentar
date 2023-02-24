package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class HomePage extends BasePage {

    String homePageUrl = "https://www.pet-centar.rs/";

    String sectionXpath = "//section[@class = 'product-list--featured']";

    @FindBy(id = "ctl53_FilterHomepage1_RptFilters_ctl00_LnkFilterName")
    private WebElement psiMenuItem;

    @FindBy(id = "ctl53_HyperLink10")
    private WebElement buttonSeeAll;

    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get(homePageUrl);
    }

    public Psi clickOnthePsiMenuItem() {
        psiMenuItem.click();
        return new Psi(driver);
    }

    public String getTitleOfSection(int index) {
        WebElement section = driver.findElement(By.xpath("//section[@class = 'product-list--featured'][" +index+"]/span"));
        return section.getText();
    }

    public Proizvodi clickSeeAllButtonOnAction(){
        buttonSeeAll.click();
        return new Proizvodi(driver);
    }


    public ArrayList<WebElement> returnSections() {
        scrollIntoView(buttonSeeAll);
        ArrayList<WebElement> sekcije = new ArrayList<>(driver.findElements(By.xpath(sectionXpath)));
        return sekcije;
    }

    //ukoliko imamo npr dve sekcije sa istim lokatorom i zelimo da vratimo listu proizvoda pod odredjenom sekcijom - mozemo da prosledimo nadjenu sekciju i onda izlistamo proizvode
    public ArrayList<WebElement> getListOfProductsUnderSection(WebElement sekcija) {
        ArrayList<WebElement> proizvodi = new ArrayList<>(sekcija.findElements(By.xpath("//article[contains (@class, 'product-item')]")));
        return proizvodi;
    }

    public ArrayList<WebElement> getListOfProductsAction() {
        scrollIntoView(buttonSeeAll);
        ArrayList<WebElement> proizvodi = new ArrayList<>(driver.findElements(By.xpath("//article[contains (@class, 'product-item has-action-price')]//h1/a")));
        return proizvodi;
    }

}
