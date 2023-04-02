package pages;

import components.Banner;
import components.ContactUsForm;
import components.Footer;
import components.SolutionItemCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    public final ContactUsForm contactUsForm;
    public final Banner banner;

    public final SolutionItemCard navigationSolutionCard;
    public final SolutionItemCard environmentalSolutionCard;
    public final SolutionItemCard qhseSolutionCard;
    public final SolutionItemCard dataSolutionCard;

    public final Footer footer;


    public Homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        contactUsForm = new ContactUsForm(driver);
        banner = new Banner(driver);
        navigationSolutionCard = new SolutionItemCard(driver, "Navigation");
        environmentalSolutionCard = new SolutionItemCard(driver, "Environmental");
        qhseSolutionCard = new SolutionItemCard(driver, "QHSE");
        dataSolutionCard = new SolutionItemCard(driver, "Data Solutions");
        footer = new Footer(driver);
    }
}
