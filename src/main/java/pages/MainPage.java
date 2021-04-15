package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Get a credit card')]")
    private WebElement getCreditCardButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.get(mainPageUrl);
        return this;
    }


    public CreditCardFormPage clickOnGetCreditCardButton() {
        getCreditCardButton.click();
        return new CreditCardFormPage(driver);
    }

}
