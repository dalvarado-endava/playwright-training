package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.components.CartNavigation;

public class Shipping extends BasePage {
    private final Locator checker;
    public CartNavigation cartNavigation;
    private final Logger log = LoggerFactory.getLogger(Shipping.class);

    public Shipping(Page page) {
        super(page);
        cartNavigation = new CartNavigation(page);
        checker = page.locator("#cgv");
    }

    @Step("Check agreement terms")
    public void checkAgreedTerms() {
        checker.check();
        log.info("Check agreement terms");
    }

    @Step("Assert that proceed checker agreed terms is visible")
    public void assertThatCheckerAgreedTermsIsVisible(){
        assertIfLocatorIsVisible(checker);
    }
}
