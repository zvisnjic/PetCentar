package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Proizvod extends BasePage{

    @FindBy(xpath = "//a[contains (@class,'addToBasket')]")
    private WebElement atToCardButton;
    @FindBy(xpath = "//input[contains (@class, 'product-quantity__input')]")
    private WebElement inputQuantity;
    @FindBy(xpath = "//a[contains (@class, 'product-quantity__plus')]")
    private WebElement plusQuantity;
    @FindBy(xpath = "//a[contains (@class, 'product-quantity__minus')]")
    private WebElement minusQuantity;

    public Proizvod(ChromeDriver driver){
        super(driver);
    }
    public Cart clickatToCartButton(){
        atToCardButton.click();
        return new Cart(driver);
    }
    public void enterQuantity(String quantity){
        inputQuantity.clear();
        inputQuantity.sendKeys(quantity);

    }
    public void quantityPlus(){
        plusQuantity.click();

    }
    public void quantityMinus(){
        minusQuantity.click();
    }
}
