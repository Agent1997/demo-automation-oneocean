package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SolutionItemCard {

    private final WebDriver driver;
    private final String title;

    public SolutionItemCard(WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
    }

    public WebElement title() {
        String titleLocatorTpl = "//div[contains(@class,'c-solutions__item')]//h2[text()='%s']";
        return driver.findElement(By.xpath(String.format(titleLocatorTpl, this.title)));
    }

    public WebElement description() {
        String descriptionLocatorTpl = "//div[contains(@class,'c-solutions__item')]//h2[text()='%s']//ancestor::div[@class='c-solutions__header']//p";
        return driver.findElement(By.xpath(String.format(descriptionLocatorTpl, this.title)));
    }

    public WebElement button(){
        String buttonLocatorTpl = "//div[contains(@class,'c-solutions__item')]//h2[text()='%s']//ancestor::div[contains(@class,'c-solutions__item')]//a";
        return driver.findElement(By.xpath(String.format(buttonLocatorTpl, this.title)));
    }

}
