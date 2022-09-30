package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class ItemPopup extends BasePage {

    private final Locator addToCartButton;

    private final Logger log = LoggerFactory.getLogger(ItemPopup.class);


    public ItemPopup(Page page) {
        super(page);
        addToCartButton = page.locator("text=Add to cart");
    }

    public void clickAddToCart() {
        addToCartButton.hover();
        addToCartButton.click();
        log.info("CLick on add to card button");
    }

}
