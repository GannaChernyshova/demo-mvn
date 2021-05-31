package pages;


import com.epam.healenium.SelfHealingDriver;
import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Get a credit card')]")
    private WebElement getCreditCardButton;

    public MainPage(SelfHealingDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Open Main page")
    public MainPage open() {
        driver.get(mainPageUrl);
        return this;
    }

    @Step("Get Credit Card")
    public CreditCardFormPage clickOnGetCreditCardButton() {
        getCreditCardButton.click();
        return new CreditCardFormPage(driver);
    }

}
