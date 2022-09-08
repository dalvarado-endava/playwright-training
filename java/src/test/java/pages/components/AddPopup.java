package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class AddPopup extends BasePage {

    public Locator proceedCheckoutButton;

    public Locator card;
    private final Logger log = LoggerFactory.getLogger(AddPopup.class);

    public AddPopup(Page page) {
        super(page);
        proceedCheckoutButton = page.locator("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
        card = page.locator("#layer_cart");
    }

    public void clickProceedCheckoutButton() {
        proceedCheckoutButton.click();
        log.info("Click on proceed checkout button");
    }
}
