package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookieModal {

    @FindBy(id = "CybotCookiebotDialogHeaderLogosWrapper")
    private WebElement modal;

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    public WebElement allowAll;


    public CookieModal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Boolean isVisible() {
        int tryCount = 4;
        long delay = 500;
        boolean isDisplayed = false;
        while (tryCount > 0) {
            try {
                isDisplayed = modal.isDisplayed();
                tryCount--;
            } catch (Exception ignore) {
                sleep(delay);
                tryCount--;
            }
        }
        return isDisplayed;
    }

    private void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
