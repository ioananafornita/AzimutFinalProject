package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver){
        super(driver);

    }
//    @FindBy(xpath = "//a[text()='Cart']")
    @FindBy(id = "cartur")
    private WebElement cartLink;
    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[text()='Delete']")
    private WebElement deleteProduct;
    @FindBy(id = "totalp")
    private WebElement totalCartPrice;
    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    public void clickCartLink() {elementMethods.clickElement(cartLink);}

    public void addItemToCart(){elementMethods.clickElement(addToCartButton);}

    public void deleteProduct(){elementMethods.clickElement(deleteProduct);}

    public void validateItemAddedToCart(String alertMessage){alertMethods.validateAlertText(alertMessage);}

    public void acceptAlert(){alertMethods.acceptAlert();}

    public void validateCartHasItem(String expectedTotal){elementMethods.validateElementText(totalCartPrice, expectedTotal);}

    public void validateCartIsEmpty()
    {
        elementMethods.waitForElementToDisappear(totalCartPrice);
    }

    public void placeOrder(String name, String country, String city, String creditCard, String month, String year){
        elementMethods.clickElement(placeOrderButton);
        WebElement nameInput = driver.findElement(By.id("name"));
        elementMethods.fillElement(nameInput, name);
        WebElement countryInput = driver.findElement(By.id("country"));
        elementMethods.fillElement(countryInput, country);
        WebElement cityInput = driver.findElement(By.id("city"));
        elementMethods.fillElement(cityInput, city);
        WebElement creditCardInput = driver.findElement(By.id("card"));
        elementMethods.fillElement(creditCardInput, creditCard);
        WebElement monthInput = driver.findElement(By.id("month"));
        elementMethods.fillElement(monthInput, month);
        WebElement yearInput = driver.findElement(By.id("year"));
        elementMethods.fillElement(yearInput, year);
        WebElement purchaseButton = driver.findElement(By.xpath("//button[text()='Purchase']"));
        elementMethods.clickElement(purchaseButton);
    }

    public void validateOrderPlaced(){
        WebElement okPurchaseButton = driver.findElement(By.xpath("//button[text()='OK']"));
        elementMethods.clickElement(okPurchaseButton);
    }
}
