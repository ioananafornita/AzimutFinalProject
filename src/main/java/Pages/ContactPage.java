package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Contact']")
    private WebElement contactLink;
    @FindBy(id = "recipient-email")
    private WebElement emailInput;
    @FindBy(id = "recipient-name")
    private WebElement contactNameInput;
    @FindBy(id = "message-text")
    private WebElement messageInput;
    @FindBy(xpath = "//button[text()='Send message']")
    private WebElement sendMessageButton;
    @FindBy(xpath = "//button[contains(@class, 'btn-secondary') and text()='Close']")
    private WebElement closeButton;

    public void clickContactLink(){elementMethods.clickElement(contactLink);}

    public void fillEmail(String email){elementMethods.fillElement(emailInput, email);}

    public void fillContactName(String contactName){elementMethods.fillElement(contactNameInput, contactName);}

    public void fillMessage(String message){elementMethods.fillElement(messageInput, message);}

    public void sendMessage(){elementMethods.clickElement(sendMessageButton);}

    public void closeWindow()
    {
        elementMethods.waitForElement(closeButton);
        elementMethods.clickElement(closeButton);
    }

    public void validateMessageSent(String alertMessage){alertMethods.validateAlertText(alertMessage);}
}
