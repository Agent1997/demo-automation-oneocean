package components;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class Footer {

    @FindBy(xpath = "//article[@class='c-feature__wrapper']//header")
    public WebElement featureTitle;

    @FindBy(xpath = "//article[@class='c-feature__wrapper']//footer/a")
    public WebElement signUpButton;

    private final WebDriver driver;

    public Footer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Footer scrollIntoView() {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUpButton);
        } catch (Exception e) {
            log.error("Unable to scroll element into view {}", e.getMessage());
        }
        return this;
    }

    public WebElement linkWithText(String text) {
        return driver.findElement(By.xpath(String.format("//ul[@id='menu-footer-links']//a[normalize-space()='%s']", text)));
    }
}
