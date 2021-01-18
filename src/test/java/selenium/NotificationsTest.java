package selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class NotificationsTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(NotificationsTest.class);


    @Test
    public void applyForMortgage() {
        LOGGER.info("applyForMortgage test start");
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickOnApplyForMortgageButton()
                .verifyPageTitle("Mortgage loan application")
                .verifyPageDescription("Step 1 of 2 Get + 20% approval by completing the first step")
                .inputName("Name")
                .inputSurname("Surname")
                .inputPhone("89992346789")
                .inputEmail("mail@mail.com")
                .clickNextStep()
                .verifyPageDescription("Step 2 of 2. Get approval by completing the second step")
                .inputPropertyType("Flat")
                .inputPropertyPrice("4000000")
                .inputPropertyDownPayment("400000")
                .clickApply()
                .verifyApplicationSuccessMessage("Thank you! Your request has been submitted. We will contact you on bank decision");
    }

    @Test
    public void applyForCreditCard() {
        LOGGER.info("applyForCreditCard test start");
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickOnGetCreditCardButton()
                .verifyPageTitle("Credit card application 100 days without%")
                .verifyPageDescription("Order now - free delivery tomorrow.")
                .inputName("Name")
                .inputSurname("Surname")
                .inputPhone("89992346789")
                .inputEmail("mail@mail.com")
                .clickApply()
                .verifyApplicationSuccessMessage("Thank you! Your data has been submitted. Manager will contact you after verification.");
    }

    @Test
    public void checkPremiumCardInfo() {
        LOGGER.info("checkPremiumCardInfo test start");
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .selectPremiumCardItem()
                .verifyTitleText("Premium Card")
                .verifyDescriptionContainsText("Get up to 3% cashback or up to 5% miles on every purchase");
    }

    @Test
    public void checkIndividualSalaryCardInfo() {
        LOGGER.info("checkIndividualSalaryCardInfo test start");
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .selectIndividualSalaryCardItem()
                .verifyTitleText("Individual salary card")
                .verifyDescriptionContainsText("Up to 2% cashback, up to 5% on the balance and 0 coins for service");
    }
}
