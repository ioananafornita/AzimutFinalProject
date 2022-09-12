package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BasePage {

    public AboutPage(WebDriver driver){
        super(driver);

    }
    @FindBy(xpath = "//a[text()='About us']")
    private WebElement aboutUsLink;
    @FindBy(xpath = "//button[@class='vjs-big-play-button' and @title='Play Video']")
    private WebElement playVideoButton;
    @FindBy(xpath = "//button[@title='Pause']")
    private WebElement pauseVideoButton;
    @FindBy(xpath = "//button[@title='Mute']")
    private WebElement muteVideoButton;
    @FindBy(xpath = "//button[text()='Close']")
    private WebElement closeButton;

    public void clickAboutUsLink(){elementMethods.clickElement(aboutUsLink);}

    public void playVideo(){elementMethods.clickElement(playVideoButton);}

    public void pauseVideo(){elementMethods.clickElement(pauseVideoButton);}

    public void muteVideo(){elementMethods.clickElement(muteVideoButton);}
}
