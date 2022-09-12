package Tests;

import Base.BaseTest;
import Pages.AboutPage;
import org.junit.Test;

public class AboutTests extends BaseTest
{
    @Test
    public void testContactUsFunctionality()
    {
        AboutPage aboutPage = new AboutPage(getDriver());
        aboutPage.clickAboutUsLink();
        aboutPage.playVideo();
        aboutPage.pauseVideo();
        aboutPage.muteVideo();
    }
}
