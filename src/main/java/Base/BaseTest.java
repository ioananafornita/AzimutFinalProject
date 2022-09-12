package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    public WebDriver Driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        Driver=new ChromeDriver();
        Driver.get("https://www.demoblaze.com/index.html#");
        Driver.manage().window().maximize();
        new WebDriverWait(Driver, Duration.ofSeconds(2));
    }

//    @After
//    public void doSomethingAfterTests()
//    {
//
//    }

    public WebDriver getDriver() {
        return Driver;
    }
}
