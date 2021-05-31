package selenium;

import com.epam.reportportal.annotations.attribute.Attribute;
import com.epam.reportportal.annotations.attribute.Attributes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class MandatoryFieldsTest extends BaseTest {

    @Test
//    @Attributes(attributes = { @Attribute(key = "healing", value = "true") })
    @DisplayName("verify That Name Is Mandatory Field For Application")
    public void verifyThatNameIsMandatoryFieldForApplication() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickOnGetCreditCardButton()
                .verifyPageTitle("Credit card application 100 days without%")
                .verifyPageDescription("Order now - free delivery tomorrow.")
                .inputSurnameValue("Surname")
                .inputPhone("89992346789")
                .inputEmail("mail@mail.com")
                .clickApply()
                .verifyErrorMessage("Required field");
    }

    @Test
    @DisplayName("verify That Name Is Mandatory Field For Application - 2")
    public void verifyThatNameIsMandatoryFieldForApplication2() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickOnGetCreditCardButton()
                .verifyPageTitle("Credit card application 100 days without%")
                .verifyPageDescription("Order now - free delivery tomorrow.")
                .inputSurnameValue("OtherSurname")
                .inputPhone("89992346789")
                .inputEmail("mail2@mail.com")
                .clickApply()
                .verifyErrorMessage("Required field");
    }
}
