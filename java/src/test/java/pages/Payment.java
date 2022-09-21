package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.components.CartNavigation;

public class Payment extends BasePage {

    public Locator payByBank;
    public CartNavigation cartNavigation;
    public Locator confirmMyOrderButton;

    public Locator successMessage;
    private final Logger log = LoggerFactory.getLogger(Payment.class);

    public Payment(Page page) {
        super(page);
        cartNavigation = new CartNavigation(page);
        payByBank = page.locator(".bankwire");
        confirmMyOrderButton = page.locator("//*[@id=\"cart_navigation\"]/button");
        successMessage = page.locator(".cheque-indent");
    }

    public void clickOnPayByBank() {
        payByBank.click();
        log.info("Click on pay by bank");
    }

    public void clickOnConfirmMyOrderButton() {
        confirmMyOrderButton.click();
        log.info("Click on confirm my order button");
    }
}
