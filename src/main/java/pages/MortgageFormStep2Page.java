package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class MortgageFormStep2Page extends BasePage {
    public MortgageFormStep2Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='price']")
    private WebElement propertyPrice;

    @FindBy(xpath = "//input[@name='payment']")
    private WebElement propertyDownPayment;

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement applyButton;

    @FindBy(css = "div.t-descr_md")
    private WebElement formDescription;


    public MortgageFormStep2Page inputPropertyType(String value) {
        Select propertySelectBox = new Select(driver.findElement(By.xpath("//select[@name='Selectbox']")));
        propertySelectBox.selectByValue(value);
        return this;
    }

    public MortgageFormStep2Page inputPropertyPrice(String price) {
        propertyPrice.sendKeys(price);
        return this;
    }


    public MortgageFormStep2Page inputPropertyDownPayment(String payment) {
        propertyDownPayment.sendKeys(payment);
        return this;
    }

    public MortgageFormStep2Page clickApply() {
        applyButton.click();
        return this;
    }

    public MortgageFormStep2Page verifyPageDescription(String description) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleContains("mortgage-step-2"));
        By descriptionLocator = By.cssSelector("div.t-descr_md");
        String descriptionText = wait.
                until(ExpectedConditions.visibilityOfElementLocated(descriptionLocator)).
                getText();
        assertThat(descriptionText, equalToIgnoringCase(description));
        return this;
    }


    public void verifyApplicationSuccessMessage(String message) {
        By successboxLocator = By.cssSelector(" .js-successbox.t-form__successbox.t-text.t-text_md");
        WebDriverWait waitForOne = new WebDriverWait(driver, 5);
        String successMessageText = waitForOne.
                until(ExpectedConditions.visibilityOfElementLocated(successboxLocator)).
                getText();
        assertThat(successMessageText, equalToIgnoringCase(message));
    }


}
