package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Cart;
import pages.HomePage;
import pages.Proizvod;
import pages.Proizvodi;

import java.util.ArrayList;

public class Addtocart {
    @Test
    public void testAddToCart(){
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    HomePage homePage = new HomePage(driver);
    homePage.acceptCookies();

    //deo ukoliko zelimo da pronadjemo dve sekcije pa prosledimo nadjenu sekciju i dalje trazimo listu proizvoda
//  ArrayList<WebElement> sekcije = homePage.returnSections();
//   for (int i = 0; i<sekcije.size(); i++){
//       String text = sekcije.get(i).findElement(By.xpath("/span")).getText();
//         if (text.contains("Proizvodi na akciji")){
//          proizvodi.get(0).click();
//        break;
//          }
//    }

        assert (homePage.getTitleOfSection(1).contains("PROIZVODI NA AKCIJI")): "Title of first section of products is invalid. Expected title is 'Proizvodi na akciji'. Actual: " + homePage.getTitleOfSection(1);

        //ne moze da klikne na prvi prozivod jer ne vidi na stranici uvek prvi prozivod - lista je dinamicka i stalno se menja
//        ArrayList<WebElement> proizvodi = homePage.getListOfProductsAction();
//        proizvodi.get(0).click();

        Proizvodi proizvodi = homePage.clickSeeAllButtonOnAction();
        ArrayList<WebElement> listaProizvodi = proizvodi.getlistofProducts();
        listaProizvodi.get(0).click();

        Proizvod proizvod = new Proizvod(driver);
        proizvod.enterQuantity("4");
        Cart addToCart= proizvod.clickatToCartButton();
        String singlePrice = addToCart.getSinglePrice();
 //       StringBuffer sb= new StringBuffer(singlePrice);
 //       sb.substring(0, sb.length()-2);
        String lines[] = singlePrice.split("\n");

        String s1 = lines[1];
        String s = s1.substring(0,5);


        double singlePriceint = Double.parseDouble(s);
        double totalPriceint = singlePriceint*4.0;
        String totalPrice = String.valueOf(totalPriceint);
        assert (addToCart.getTotalPrice().contains(totalPrice)):"expected " + totalPrice + "but actual" + addToCart.getTotalPrice();


        driver.quit();

}
    }

