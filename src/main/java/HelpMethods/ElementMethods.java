package HelpMethods;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementMethods {

    public WebDriver Driver;

    public ElementMethods(WebDriver driver) {
        Driver = driver;
    }

    public void clickElement(WebElement element){
        waitForElement(element);
        element.click();
    }

    public void fillElement(WebElement element, String value){
        waitForElement(element);
        element.sendKeys(value);
    }

    public void validateElementText(WebElement element, String expectedValue){
        waitForElement(element);
        String actualValue = element.getText();
        Assert.assertEquals("Text message is not correct!", expectedValue, actualValue);
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToDisappear(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
