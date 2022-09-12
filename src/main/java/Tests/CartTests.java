package Tests;

import Base.BaseTest;
import Pages.AboutPage;
import Pages.CartPage;
import Pages.IndexPage;
import org.junit.Test;

public class CartTests extends BaseTest
{
    @Test
    public void testAddItemToCart()
    {
        IndexPage indexPage = new IndexPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        indexPage.openGalaxyS7PhonePage();
        indexPage.validateS7PhonePageOpened();
        cartPage.addItemToCart();
        cartPage.validateItemAddedToCart("Product added");
        cartPage.acceptAlert();
        cartPage.clickCartLink();
        cartPage.validateCartHasItem("800");
    }

    @Test
    public void testAddMultipleItemsToCart()
    {
        IndexPage indexPage = new IndexPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        indexPage.openGalaxyS7PhonePage();
        indexPage.validateS7PhonePageOpened();
        cartPage.addItemToCart();
        cartPage.validateItemAddedToCart("Product added");
        cartPage.acceptAlert();
        indexPage.clickHomeLink();
        indexPage.openSonyVaioI5Page();
        indexPage.validateSonyVaioI5PageOpened();
        cartPage.addItemToCart();
        cartPage.validateItemAddedToCart("Product added");
        cartPage.acceptAlert();
        cartPage.clickCartLink();
        cartPage.validateCartHasItem("1590");
    }

    @Test
    public void testDeleteFromCart()
    {
        IndexPage indexPage = new IndexPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        indexPage.openGalaxyS7PhonePage();
        indexPage.validateS7PhonePageOpened();
        cartPage.addItemToCart();
        cartPage.validateItemAddedToCart("Product added");
        cartPage.acceptAlert();
        cartPage.clickCartLink();
        cartPage.validateCartHasItem("800");
        cartPage.deleteProduct();
        cartPage.validateCartIsEmpty();
    }

    @Test
    public void testPlaceOrder()
    {
        IndexPage indexPage = new IndexPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        indexPage.openGalaxyS7PhonePage();
        indexPage.validateS7PhonePageOpened();
        cartPage.addItemToCart();
        cartPage.validateItemAddedToCart("Product added");
        cartPage.acceptAlert();
        cartPage.clickCartLink();
        cartPage.validateCartHasItem("800");
        cartPage.placeOrder("Nafornita Ioana", "Romania", "Cluj-Napoca", "9999 8888 7777 6666", "8", "2022");
        cartPage.validateOrderPlaced();
    }
}
