package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.components.CartSummary;

public class Payment extends BasePage {

    private final Locator payByBank;
    private final Locator confirmMyOrderButton;
    private final Locator successMessage;
    private final Logger log = LoggerFactory.getLogger(Payment.class);

    public CartSummary cartSummary;

    public Payment(Page page) {
        super(page);
        payByBank = page.locator(".bankwire");
        confirmMyOrderButton = page.locator("//*[@id=\"cart_navigation\"]/button");
        successMessage = page.locator(".cheque-indent");
        cartSummary = new CartSummary(page);
    }

    @Step("Click on pay by bank")
    public void clickOnPayByBank() {
        payByBank.hover();
        payByBank.click();
        log.info("Click on pay by bank");
    }

    @Step("Click on confirm my order button")
    public void clickOnConfirmMyOrderButton() {
        confirmMyOrderButton.hover();
        confirmMyOrderButton.click();
        log.info("Click on confirm my order button");
    }

    @Step("Assert that pay bank is visible")
    public void assertThatPayBankIsVisible() {
        assertIfLocatorIsVisible(payByBank);
    }

    @Step("Assert that confirm my order button is visible")
    public void assertThatConfirmMyOrderButtonIsVisible() {
        assertIfLocatorIsVisible(confirmMyOrderButton);
    }

    @Step("Assert that success message contains text {0}")
    public void assertThatSuccessMessageContainsText(String text) {
        assertThatElementContainsText(successMessage, text);
    }
}
