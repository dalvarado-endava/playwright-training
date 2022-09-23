package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class AddPopup extends BasePage {

    public Locator proceedCheckoutButton;

    public Locator cart;

    public Locator continueShopping;
    private final Logger log = LoggerFactory.getLogger(AddPopup.class);

    public AddPopup(Page page) {
        super(page);
        proceedCheckoutButton = page.locator(".button-container>> text= Proceed to checkout");
        cart = page.locator("#layer_cart");
        continueShopping = page.locator(".button-container>> text=Continue shopping");
    }

    @Step("Click on proceed checkout button")
    public void clickOnProceedCheckoutButton() {
        proceedCheckoutButton.hover();
        proceedCheckoutButton.click();
        log.info("Click on proceed checkout button");
    }

    @Step("Click on continue Shopping button")
    public void clickOnContinueShoppingButton() {
        continueShopping.click();
        log.info("Click on continue Shopping button");
    }
}