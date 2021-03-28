package selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.MainPage;


public class NotificationsTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(NotificationsTest.class);

    @Test
    public void applyForCreditCardWithNameError() {
        LOGGER.info("applyForCreditCardWithNameError test start");
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickOnGetCreditCardButton()
                .verifyPageTitle("Credit card application 100 days without%")
                .verifyPageDescription("Order now - free delivery tomorrow.")
                .inputSurname("Surname")
                .inputPhone("89992346789")
                .inputEmail("mail@mail.com")
                .clickApply()
                .verifyErrorMessage("Required field");
    }
}
