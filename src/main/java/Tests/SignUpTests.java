package Tests;

import Base.BaseTest;
import Pages.SignUpPage;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class SignUpTests extends BaseTest
{
    private final String userName = "nafornitaIoana";
    private final String password = "parola123";

    @Test
    public void testSignUpValid()
    {
        int randomNum = ThreadLocalRandom.current().nextInt(10000, 99999);
        SignUpPage signUpPage = new SignUpPage(getDriver());
        signUpPage.clickSignUpLink();
        signUpPage.signUp(userName + randomNum, password);
        signUpPage.validateAlert("Sign up successful.");
        signUpPage.acceptAlert();
    }

    @Test
    public void testSignUpUserAlreadyExists()
    {
        SignUpPage signUpPage = new SignUpPage(getDriver());
        signUpPage.clickSignUpLink();
        signUpPage.signUp(userName, password);
        signUpPage.validateAlert("This user already exist.");
        signUpPage.acceptAlert();
    }
}
