package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.ArrayList;

public class FilterDogFood extends BaseTest{
//test
    @Test
    public void testFilterDogFood (){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        Psi psi = homePage.clickOnthePsiMenuItem();
        Hrana hrana = psi.clickOnHranaMenuItem();
        hrana.clickOnRobnaMarkaVidiSveButton();
        WolfPack wolfPack = hrana.clickOnWolfPackRobnaMarka();
        ArrayList <String> listaProizvoda = wolfPack.getTitlesOfAllProducts();
        for (int i = 0; i<listaProizvoda.size(); i++){
            assert listaProizvoda.get(i).contains("WOLFPACK"): "This item is not Wolfpack";
        }
        driver.quit();


    }



}
