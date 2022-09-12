package Pages;

import Base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver){
        super(driver);

    }

    //elementele specifice acestei pagini
    private final String pageTitle = "STORE";

    @FindBy(xpath = "//a[text()='Home ']")
    private WebElement homeLink;
    @FindBy(xpath = "//a[@data-slide='next']")
    private WebElement nextImageButton;
    @FindBy(xpath = "//a[@data-slide='prev']")
    private WebElement previousImageButton;
    @FindBy(xpath = "//a[text()='Phones']")
    private WebElement phonesTab;
    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement laptopsTab;
    @FindBy(xpath = "//a[text()='Monitors']")
    private WebElement monitorsTab;
    @FindBy(xpath = "//a[text()='Samsung galaxy s7']")
    private WebElement galaxyS7Phone;
    @FindBy(tagName = "h2")
    private WebElement productHeaderTitle;
    @FindBy(id = "next2")
    private WebElement nextPageButton;
    @FindBy(id = "prev2")
    private WebElement previousPageButton;
    @FindBy(xpath = "//a[text()='Apple monitor 24']")
    private WebElement appleMonitor24;
    @FindBy(xpath = "//a[text()='Sony vaio i5']")
    private WebElement sonyVaioI5;


    //metodele specifice acestei clase

    public void clickHomeLink(){elementMethods.clickElement(homeLink);}

    public void clickNextProductImage(){elementMethods.clickElement(nextImageButton);}

    public void clickPreviousProductImage(){elementMethods.clickElement(previousImageButton);}

    public void validateTitle() { pageMethods.validateTitlePage(pageTitle);}

    public void clickPhonesTab(){
        elementMethods.clickElement(phonesTab);
    }

    public void clickLaptopsTab(){
        elementMethods.clickElement(laptopsTab);
    }

    public void clickMonitorsTab(){
        elementMethods.clickElement(monitorsTab);
    }

    public void openGalaxyS7PhonePage(){elementMethods.clickElement(galaxyS7Phone);}

    public void validateS7PhonePageOpened(){elementMethods.validateElementText(productHeaderTitle, "Samsung galaxy s7");}

    public void clickNextPageButton(){
        pageMethods.scrollDownPage(400);
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementMethods.clickElement(nextPageButton);
    }

    public void clickPreviousPageButton(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementMethods.clickElement(previousPageButton);
    }

    public void openAppleMonitor24Page(){elementMethods.clickElement(appleMonitor24);}

    public void validateAppleMonitor24PageOpened(){elementMethods.validateElementText(productHeaderTitle, "Apple monitor 24");}

    public void openSonyVaioI5Page(){elementMethods.clickElement(sonyVaioI5);}

    public void validateSonyVaioI5PageOpened(){elementMethods.validateElementText(productHeaderTitle, "Sony vaio i5");}

    public void validatePhoneProductNotPresent()
    {
        this.validateProductNotPresent("//a[text()='Samsung galaxy s7']");
    }

    public void validateLaptopProductNotPresent()
    {
        this.validateProductNotPresent("//a[text()='Sony vaio i5']");
    }

    public void validateMonitorProductNotPresent()
    {
        this.validateProductNotPresent("//a[text()='Apple monitor 24']");
    }

    private void validateProductNotPresent(String elementXpath)
    {
        try
        {
            WebElement product = driver.findElement(By.xpath(elementXpath));
            elementMethods.waitForElementToDisappear(product);
            Assert.assertFalse("This product should not be shown here!", product.isDisplayed());
        } catch(Exception e){
            return;
        }
    }
}
