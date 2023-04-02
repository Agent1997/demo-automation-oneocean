package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.Timeouts.GLOBAL_TIMEOUT;

public class Banner {

    @FindBy(xpath = "//h1[contains(@class,'c-blkbanner__title')]")
    public WebElement title;

    @FindBy(xpath = "//h1[contains(@class,'c-blkbanner__title')]//following-sibling::p")
    public WebElement description;
    private final WebDriver driver;

    public Banner(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, GLOBAL_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public WebElement buttonWithText(String text) {
        return driver.findElement(By.xpath(String.format("//div[@class='c-blkbanner__buttons']//*[contains(text(),'%s')]", text)));
    }

}
