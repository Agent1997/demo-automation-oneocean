package tests;

import components.Footer;
import helpers.Navigation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Homepage;

import static helpers.Driver.launchChromeDriver;

public class FooterTest {

    private WebDriver driver;
    private Navigation navigate;

    @BeforeClass
    public void testSetup() {
        driver = launchChromeDriver();
        navigate = new Navigation(driver);
        navigate.openWebSiteInBrowser();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void verifyNewsLetterSignupBanner() {
        Homepage homepage = navigate.toHomepage();
        Footer footer = homepage.footer.scrollIntoView();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(footer.featureTitle.getText(), "Subscribe to our newsletters");
        sa.assertTrue(footer.signUpButton.isDisplayed());

        footer.signUpButton.click();
        sa.assertEquals(driver.getCurrentUrl(), "https://www.oneocean.com/newsletter-sign-up/");
        sa.assertAll();
    }

    @Test(dataProvider = "Footer Links")
    public void verifyFooterLinks(String linkText, String expUrlWhenClicked) {
        Homepage homepage = navigate.toHomepage();
        Footer footer = homepage.footer.scrollIntoView();

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(footer.linkWithText(linkText).isDisplayed());

        footer.linkWithText(linkText).click();
        sa.assertEquals(driver.getCurrentUrl(), expUrlWhenClicked);
        sa.assertAll();
    }

    @DataProvider(name = "Footer Links")
    public Object[][] footerLinkTestData() {
        return new Object[][]{
                {"Solutions", "https://www.oneocean.com/solutions/"},
                {"Navigation", "https://www.oneocean.com/solutions/navigation/"},
                {"Environmental", "https://www.oneocean.com/solutions/environmental/"},
                {"QHSE", "https://www.oneocean.com/solutions/qhse/"},
                {"Data Solutions", "https://www.oneocean.com/solutions/data-solutions/"},
                {"Services", "https://www.oneocean.com/services/"},
                {"Guide to Port Entry", "https://www.oneocean.com/services/guide-to-port-entry/"},
                {"SeaTab", "https://www.oneocean.com/services/seatab/"},
                {"About us", "https://www.oneocean.com/about-us/"},
                {"Our Vision", "https://www.oneocean.com/about-us/our-vision/"},
                {"Why OneOcean?", "https://www.oneocean.com/about-us/why-choose-oneocean/"},
                {"CSR", "https://www.oneocean.com/about-us/csr/"},
                {"Code of Ethics", "https://www.oneocean.com/about-us/code-of-ethics/"},
                {"Management Team", "https://www.oneocean.com/about-us/management-team/"},
                {"Locations", "https://www.oneocean.com/contact/locations/"}
        };
    }
}
