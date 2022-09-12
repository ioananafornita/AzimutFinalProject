package Tests;

import Base.BaseTest;
import org.junit.Test;
import Pages.IndexPage;

public class IndexTests extends BaseTest
{
    @Test
    public void testIndexPage()
    {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.validateTitle();
        indexPage.clickNextProductImage();
        indexPage.clickPreviousProductImage();
    }

    @Test
    public void testPhonesCategory()
    {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickPhonesTab();
        indexPage.validateLaptopProductNotPresent();
        indexPage.validateMonitorProductNotPresent();
        indexPage.openGalaxyS7PhonePage();
        indexPage.validateS7PhonePageOpened();
    }

    @Test
    public void testLaptopsCategory()
    {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickLaptopsTab();
        indexPage.validatePhoneProductNotPresent();
        indexPage.validateMonitorProductNotPresent();
        indexPage.openSonyVaioI5Page();
        indexPage.validateSonyVaioI5PageOpened();
    }

    @Test
    public void testMonitorsCategory()
    {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickMonitorsTab();
        indexPage.validatePhoneProductNotPresent();
        indexPage.validateLaptopProductNotPresent();
        indexPage.openAppleMonitor24Page();
        indexPage.validateAppleMonitor24PageOpened();
    }

    @Test
    public void testNextPageButton()
    {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickNextPageButton();
        indexPage.openAppleMonitor24Page();
        indexPage.validateAppleMonitor24PageOpened();
    }

    @Test
    public void testPreviousPageButton()
    {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickNextPageButton();
        indexPage.clickPreviousPageButton();
        indexPage.openGalaxyS7PhonePage();
        indexPage.validateS7PhonePageOpened();
    }
}
