package components;

import helpers.ContactUsFormDetails;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.Timeouts.GLOBAL_TIMEOUT;

public class ContactUsForm {

    @FindBy(id = "Title__c")
    public WebElement titleSelect;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Company")
    public WebElement company;

    @FindBy(id = "Title")
    public WebElement jobTitleSelect;

    @FindBy(id = "Country__c")
    public WebElement countrySelect;

    @FindBy(id = "Contact_me_Demo__c")
    public WebElement howCanWeHelpSelect;

    @FindBy(id = "Privacy_Statement_Terms_of_Use__c")
    public WebElement privacyPolicyCheckBox;

    @FindBy(id = "Marketing_opt_in__c")
    public WebElement marketingCheckBox;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    public WebElement submitButton;


    public ContactUsForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, GLOBAL_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(titleSelect));
    }

    @Step
    public ContactUsForm fillout(ContactUsFormDetails formDetails) {
        Select select;
        if (formDetails.getTitle() != null) {
            select = new Select(titleSelect);
            select.selectByValue(formDetails.getTitle());
        }
        if (formDetails.getFirstName() != null) {
            firstName.sendKeys(formDetails.getFirstName());
        }
        if (formDetails.getLastName() != null) {
            lastName.sendKeys(formDetails.getLastName());
        }
        if (formDetails.getEmailAddress() != null) {
            email.sendKeys(formDetails.getEmailAddress());
        }
        if (formDetails.getCompany() != null) {
            company.sendKeys(formDetails.getCompany());
        }
        if (formDetails.getJobTitle() != null) {
            select = new Select(jobTitleSelect);
            select.selectByValue(formDetails.getJobTitle());
        }
        if (formDetails.getCountry() != null) {
            select = new Select(countrySelect);
            select.selectByValue(formDetails.getCountry());
        }
        if (formDetails.getHelp() != null) {
            select = new Select(howCanWeHelpSelect);
            select.selectByValue(formDetails.getHelp());
        }
        if (formDetails.getMarketing() != null) {
            if (formDetails.getMarketing()) {
                if (!marketingCheckBox.isSelected()) {
                    marketingCheckBox.click();
                }
            } else {
                if (marketingCheckBox.isSelected()) {
                    marketingCheckBox.click();
                }
            }
        }
        if (formDetails.getPrivacy() != null) {
            if (formDetails.getPrivacy()) {
                if (!privacyPolicyCheckBox.isSelected()) {
                    privacyPolicyCheckBox.click();
                }
            } else {
                if (privacyPolicyCheckBox.isSelected()) {
                    privacyPolicyCheckBox.click();
                }
            }
        }
        submitButton.click();
        return this;
    }

}
