package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class WolfPack extends BasePage {

    public WolfPack(ChromeDriver driver) {
        super(driver);
    }

    public ArrayList<String> getTitlesOfAllProducts() {
        ArrayList<WebElement> listOfProducts = new ArrayList<>(driver.findElementsByXPath("//section/article[contains (@class, 'product-item')]//h1"));
        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < listOfProducts.size(); i++) {
            String title = listOfProducts.get(i).getText();
            titles.add(title);
        }
        return titles;
    }

}


