package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.sql.Struct;

public class Cart extends BasePage{

    @FindBy(xpath = "//td[@class='basket__product-price']")
    private WebElement singlePrice;

    @FindBy(xpath = "//td[@class='basket__product-total-price']")
    private WebElement totalPrice;

    public Cart(ChromeDriver driver){
        super(driver);
    }

    public String getSinglePrice(){
       return singlePrice.getText();
    }

    public String getTotalPrice(){
        return totalPrice.getText();
    }



}
