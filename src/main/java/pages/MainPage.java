package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Get a credit card')]")
    private WebElement getCreditCardButton;

    @FindBy(xpath = "//*[text()='Apply']")
    private WebElement applyForMortgageButton;

//    @FindBy(xpath = "//div[@class='t754__textwrapper']/div[text()='Premium Card']")
    @FindBy(xpath = "(//div[@class='t754__content'])[1]")
    private WebElement premiumCardItem;

//    @FindBy(xpath = "//div[@class='t754__textwrapper']/div[text()='Individual salary card']")
    @FindBy(xpath = "(//div[@class='t754__content'])[2]")
    private WebElement individualSalaryCardItem;


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

    public MortgageFormStep1Page clickOnApplyForMortgageButton() {
        applyForMortgageButton.click();
        return new MortgageFormStep1Page(driver);
    }

    public CardCommonDescriptionPage selectPremiumCardItem() {
        driver.findElement(By.xpath("(//a[@class='js-product-link'])[1]")).click();
        return new CardCommonDescriptionPage(driver);
    }

    public CardCommonDescriptionPage selectIndividualSalaryCardItem() {
        WebElement el = driver.findElement(By.xpath("(//a[@class='js-product-link'])[2]"));
        el.click();
        individualSalaryCardItem.click();
        return new CardCommonDescriptionPage(driver);
    }
}
