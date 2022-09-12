package Pages;

import Base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);

    }
    @FindBy(xpath = "//a[text()='Log in']")
    private WebElement loginLink;
    @FindBy(id = "loginusername")
    private WebElement usernameInput;
    @FindBy(id = "loginpassword")
    private WebElement passwordInput;

    public void clickLoginLink() {elementMethods.clickElement(loginLink);}

    public void login(String username, String password)
    {
        elementMethods.fillElement(usernameInput, username);
        elementMethods.fillElement(passwordInput, password);
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        elementMethods.clickElement(loginButton);
    }

    public void validateAlert(String expectedMessage) {alertMethods.validateAlertText(expectedMessage);}

    public void acceptAlert() {alertMethods.acceptAlert();}

    public void confirmLogin(String username)
    {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement welcomeMessage = driver.findElement(By.id("nameofuser"));
        elementMethods.waitForElement(welcomeMessage);
        Assert.assertTrue("Logged in failed!", welcomeMessage.getText().equals("Welcome " + username));
    }

    public void logOut()
    {
        WebElement logOutButton = driver.findElement(By.id("logout2"));
        elementMethods.clickElement(logOutButton);
        try
        {
            WebElement welcomeMessage = driver.findElement(By.id("nameofuser"));
            elementMethods.waitForElementToDisappear(welcomeMessage);
            Assert.assertFalse("Welcome message still exists! This might be a bug", welcomeMessage.isDisplayed());
        } catch (Exception e)
        {
            return;
        }
    }
}
