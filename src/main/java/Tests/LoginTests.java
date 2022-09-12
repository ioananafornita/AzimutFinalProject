package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import org.junit.Test;

public class LoginTests extends BaseTest
{
    private final String userName = "nafornitaIoana";
    private final String password = "parola123";

    @Test
    public void testLoginValid()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickLoginLink();
        loginPage.login(userName, password);
        loginPage.confirmLogin(userName);
    }

    @Test
    public void testLogOut()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickLoginLink();
        loginPage.login(userName, password);
        loginPage.confirmLogin(userName);
        loginPage.logOut();
    }

    @Test
    public void testLoginInvalidPassword()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickLoginLink();
        loginPage.login(userName, "parola");
        loginPage.validateAlert("Wrong password.");
        loginPage.acceptAlert();
    }

    @Test
    public void testLoginUserDoesNotExist()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickLoginLink();
        loginPage.login(userName + "231", "parola");
        loginPage.validateAlert("User does not exist.");
        loginPage.acceptAlert();
    }
}
