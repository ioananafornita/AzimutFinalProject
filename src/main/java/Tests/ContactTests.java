package Tests;

import Base.BaseTest;
import Pages.ContactPage;
import org.junit.Test;

public class ContactTests extends BaseTest
{
    @Test
    public void testContactUsFunctionality()
    {
        ContactPage contactPage = new ContactPage(getDriver());
        contactPage.clickContactLink();
        contactPage.fillEmail("nafornita.ioana@gmail.com");
        contactPage.fillContactName("Nafornita Ioana");
        contactPage.fillMessage("Hello! I would like to contact your product store. \n Best wishes, Ioana.");
        contactPage.sendMessage();
        contactPage.validateMessageSent("Thanks for the message!!");
    }

    @Test
    public void testContactUsCloseWindow()
    {
        ContactPage contactPage = new ContactPage(getDriver());
        contactPage.clickContactLink();
        contactPage.closeWindow();
    }
}
