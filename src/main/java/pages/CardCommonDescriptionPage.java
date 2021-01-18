package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CardCommonDescriptionPage extends BasePage {
    public CardCommonDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'t754__product-full') and @style='display: block;']//div[contains(@class,'t-name_xl')]")
    private WebElement cardTitle;

    @FindBy(xpath = "//div[contains(@class,'t754__product-full') and @style='display: block;']//div[contains(@class,'t-descr_xxs')]")
    private WebElement cardDescription;

    @FindBy(xpath = "//div[text()='Back to products']")
    private WebElement backToProducts;


    public CardCommonDescriptionPage verifyTitleText(String title) {
        String successMessageText = cardTitle.getText();
        assertThat(successMessageText, equalToIgnoringCase(title));
        return this;
    }

    public CardCommonDescriptionPage verifyDescriptionContainsText(String description) {
        String successMessageText = cardDescription.getText();
        assertThat(successMessageText, containsString(description));
        return this;
    }

    public CardCommonDescriptionPage clickBackToProducts() {
        backToProducts.click();
        return this;
    }
}
