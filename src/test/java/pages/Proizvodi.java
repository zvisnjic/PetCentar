package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Proizvodi extends BasePage{
    public Proizvodi(ChromeDriver driver){
        super (driver);

    }
    public ArrayList<WebElement> getlistofProducts() {
        ArrayList<WebElement> listOfProducts = new ArrayList<>(driver.findElementsByXPath("//section/article[contains (@class, 'product-item')]//h1"));
       return listOfProducts;
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
    public String getTitleofProduct(WebElement product){


        return product.getText();



    }


}

