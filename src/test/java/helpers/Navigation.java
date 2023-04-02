package helpers;

import components.CookieModal;
import org.openqa.selenium.WebDriver;
import pages.Homepage;

import static helpers.Urls.HOMEPAGE;

public class Navigation {

    private final WebDriver driver;

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    public Homepage openWebSiteInBrowser() {
        driver.get(HOMEPAGE);

        CookieModal cookieModal = new CookieModal(driver);
        if (cookieModal.isVisible()) {
            cookieModal.allowAll.click();
        }

        return new Homepage(driver);
    }

    public Homepage toHomepage() {
        driver.get(HOMEPAGE);
        return new Homepage(driver);
    }
}
