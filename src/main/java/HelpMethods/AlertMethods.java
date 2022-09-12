package HelpMethods;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    public WebDriver Driver;

    public AlertMethods(WebDriver driver) {
        Driver = driver;
    }

    public void acceptAlert(){
        waitUntilAlertIsPresent();
        Alert simpleAlert= Driver.switchTo().alert();
        simpleAlert.accept();
    }

    public void validateAlertText(String expectedValue)
    {
        waitUntilAlertIsPresent();
        Alert simpleAlert = Driver.switchTo().alert();
        String actualValue = simpleAlert.getText();
        Assert.assertTrue("The alert message is not the one expected!", actualValue.equals(expectedValue));
    }

    private void waitUntilAlertIsPresent()
    {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
