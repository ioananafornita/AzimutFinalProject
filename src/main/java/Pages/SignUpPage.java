package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver){
        super(driver);

    }
    @FindBy(xpath = "//a[text()='Sign up']")
    private WebElement signUpLink;
    @FindBy(id = "sign-username")
    private WebElement usernameInput;
    @FindBy(id = "sign-password")
    private WebElement passwordInput;

    public void clickSignUpLink() {elementMethods.clickElement(signUpLink);}

    public void signUp(String username, String password)
    {
        elementMethods.fillElement(usernameInput, username);
        elementMethods.fillElement(passwordInput, password);
        WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Sign up']"));
        elementMethods.clickElement(signUpButton);
    }

    public void validateAlert(String expectedMessage)
    {
        alertMethods.validateAlertText(expectedMessage);
    }

    public void acceptAlert() {alertMethods.acceptAlert();}
}
