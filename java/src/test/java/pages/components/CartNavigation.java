package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class CartNavigation extends BasePage {

    private final Locator summary;
    public Locator proceedCheckoutButton;
    private final Locator proceedCheckoutButton2;
    private final Logger log = LoggerFactory.getLogger(CartNavigation.class);

    public CartNavigation(Page page) {
        super(page);
        summary = page.locator("#order_step > li.step_current.first");
        proceedCheckoutButton = page.locator(".button.btn.btn-default.standard-checkout.button-medium");
        proceedCheckoutButton2 = page.locator("//*[@id=\"center_column\"]/form/p/button");
    }

    @Step("Click on proceed checkout button")
    public void clickOnProceedCheckoutButton() {
        proceedCheckoutButton.hover();
        proceedCheckoutButton.click();
        log.info("Click on proceed checkout button");
    }

    @Step("Click on proceed checkout button")
    public void clickOnProceedCheckoutButton2() {
        proceedCheckoutButton2.hover();
        proceedCheckoutButton2.click();
        log.info("Click on proceed checkout button");
    }

    @Step("Assert that Summary is visible")
    public void assertThatSummaryIsVisible() {
        assertIfLocatorIsVisible(summary);
    }

    @Step("Assert that proceed checkout button is visible")
    public void assertThatProceedCheckoutButtonIsVisible() {
        assertIfLocatorIsVisible(proceedCheckoutButton);
    }

    @Step("Assert that proceed checkout button is visible")
    public void assertThatProceedCheckoutButton2IsVisible() {
        assertIfLocatorIsVisible(proceedCheckoutButton2);
    }
}