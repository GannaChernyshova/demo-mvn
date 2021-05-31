package pages;

import com.epam.healenium.SelfHealingDriver;
import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CreditCardFormPage extends BasePage{
    public CreditCardFormPage(SelfHealingDriver driver) {
        super(driver);
    }

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

    @Step("Page title is '{title}'")
    public CreditCardFormPage verifyPageTitle(String title) {
        By titleLocator = By.cssSelector("div.t-title_xs");
        WebDriverWait wait = new
                WebDriverWait(driver, 5);
        WebElement titleElem = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        String titleText = titleElem.getText();
        assertThat(titleText, equalToIgnoringCase(title));
        return this;
    }

    @Step("Page description is '{description}'")
    public CreditCardFormPage verifyPageDescription(String description) {
        By descriptionLocator = By.cssSelector("div.t-descr_md");
        WebDriverWait wait = new
                WebDriverWait(driver, 5);
        WebElement descriptionElem = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionLocator));
        String descriptionText = descriptionElem.getText();
        assertThat(descriptionText, equalToIgnoringCase(description));
        return this;
    }

    @Step("Input Surname '{surname}'")
    public CreditCardFormPage inputSurnameValue(String surname) {
        surnameInput.sendKeys(surname);
        return this;
    }


    @Step("Input Phone '{phone}'")
    public CreditCardFormPage inputPhone(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    @Step("Input Email '{email}'")
    public CreditCardFormPage inputEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Verify Name error message is '{message}'")
    public CreditCardFormPage verifyErrorMessage(String message) {
        By descriptionLocator = By.cssSelector("div.t-input-error");
        WebDriverWait wait = new
                WebDriverWait(driver, 5);
        WebElement descriptionElem = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionLocator));
        String descriptionText = descriptionElem.getText();
        assertThat(descriptionText, equalToIgnoringCase(message));
        return this;
    }


    public CreditCardFormPage clickApply() {
        applyButton.click();
        return this;
    }
}
