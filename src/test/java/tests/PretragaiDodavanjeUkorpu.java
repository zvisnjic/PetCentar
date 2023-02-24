package tests;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.ArrayList;

public class PretragaiDodavanjeUkorpu extends  BaseTest{
    @Test
    public void testPretragaiDodavanjeUkorpu(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        HomePage homePage=new HomePage(driver);
        homePage.acceptCookies();
        Proizvodi proizvodi = search("igracke",driver);

        ArrayList <String> listaProizvoda= proizvodi.getTitlesOfAllProducts();
        for (int i = 0; i<listaProizvoda.size(); i++){
            if (listaProizvoda.get(i).contains("KONG Igračka za pse AirDog")) {
                proizvodi.getlistofProducts().get(i).click();
                break;
            }
            }
//        ArrayList<WebElement> listaProizvoda=proizvodi.getlistofProducts();
//        for (int i = 0; i<listaProizvoda.size(); i++){
//            if (proizvodi.getTitleofProduct(listaProizvoda.get(i)).contains("KONG")){
//                listaProizvoda.get(i).click();
//                break;
//            }
            Proizvod proizvod = new Proizvod(driver);

            proizvod.clickatToCartButton();


         }

            }



