package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CreditCardFormPage extends BasePage{
    public CreditCardFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@placeholder='Surname']")
    private WebElement surnameInput;

    @FindBy(xpath = "//input[@placeholder='Phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement applyButton;

    @FindBy(css = "div.t-title_xs")
    private WebElement formTitle;

    @FindBy(css = "div.t-descr_md")
    private WebElement formDescription;


    public CreditCardFormPage verifyPageTitle(String title) {
        By titleLocator = By.cssSelector("div.t-title_xs");
        WebDriverWait wait = new
                WebDriverWait(driver, 5);
        WebElement titleElem = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        String titleText = titleElem.getText();
        assertThat(titleText, equalToIgnoringCase(title));
        return this;
    }

    public CreditCardFormPage verifyPageDescription(String description) {
        By descriptionLocator = By.cssSelector("div.t-descr_md");
        WebDriverWait wait = new
                WebDriverWait(driver, 5);
        WebElement descriptionElem = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionLocator));
        String descriptionText = descriptionElem.getText();
        assertThat(descriptionText, equalToIgnoringCase(description));
        return this;
    }


    public CreditCardFormPage inputName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public CreditCardFormPage inputSurname(String surname) {
        surnameInput.sendKeys(surname);
        return this;
    }


    public CreditCardFormPage inputPhone(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    public CreditCardFormPage inputEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public MortgageFormStep2Page clickApply() {
        applyButton.click();
        return new MortgageFormStep2Page(driver);
    }
}
