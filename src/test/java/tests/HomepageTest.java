package tests;

import helpers.Navigation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Homepage;

import static helpers.Driver.launchChromeDriver;

public class HomepageTest {


    private Navigation navigate;
    private WebDriver driver;

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
    public void verifyHomepageBanner() {
        String contactUs = "CONTACT US";
        Homepage homepage = navigate.toHomepage();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(homepage.banner.title.getText(), "Onboard. Onshore. Online.");
        sa.assertEquals(homepage.banner.description.getText(), "OneOcean enables informed and compliant voyage decision-making.");
        sa.assertTrue(homepage.banner.buttonWithText(contactUs).isDisplayed());

        homepage.banner.buttonWithText(contactUs).click();
        sa.assertEquals(driver.getCurrentUrl(), "https://www.oneocean.com/#contact-form");
        sa.assertAll();
    }

    @Test
    public void verifyNavigationSolutionCard() {
        Homepage homepage = navigate.toHomepage();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(homepage.navigationSolutionCard.title().getText(), "Navigation");
        sa.assertEquals(homepage.navigationSolutionCard.description().getText(), "Enable dynamic decision-making at sea and onshore.");
        sa.assertTrue(homepage.navigationSolutionCard.button().isDisplayed());

        homepage.navigationSolutionCard.button().click();

        sa.assertEquals(driver.getCurrentUrl(), "https://www.oneocean.com/solutions/navigation/");
        sa.assertAll();
    }

    @Test
    public void verifyEnvironmentalSolutionCard() {
        Homepage homepage = navigate.toHomepage();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(homepage.environmentalSolutionCard.title().getText(), "Environmental");
        sa.assertEquals(homepage.environmentalSolutionCard.description().getText(), "Informed action for environmental compliance.");
        sa.assertTrue(homepage.environmentalSolutionCard.button().isDisplayed());

        homepage.environmentalSolutionCard.button().click();

        sa.assertEquals(driver.getCurrentUrl(), "https://www.oneocean.com/solutions/environmental/");
        sa.assertAll();
    }

    @Test
    public void verifyQhseSolutionCard() {
        Homepage homepage = navigate.toHomepage();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(homepage.qhseSolutionCard.title().getText(), "QHSE");
        sa.assertEquals(homepage.qhseSolutionCard.description().getText(), "Deliver safe and compliant fleet operations.");
        sa.assertTrue(homepage.qhseSolutionCard.button().isDisplayed());

        homepage.qhseSolutionCard.button().click();

        sa.assertEquals(driver.getCurrentUrl(), "https://www.oneocean.com/solutions/qhse/");
        sa.assertAll();
    }

    @Test
    public void verifyDataSolutionsCard() {
        Homepage homepage = navigate.toHomepage();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(homepage.dataSolutionCard.title().getText(), "Data Solutions");
        sa.assertEquals(homepage.dataSolutionCard.description().getText(), "Harness the power of quality data your way.");
        sa.assertTrue(homepage.dataSolutionCard.button().isDisplayed());

        homepage.dataSolutionCard.button().click();
        sa.assertEquals(driver.getCurrentUrl(), "https://www.oneocean.com/solutions/data-solutions/");
        sa.assertAll();
    }
}
