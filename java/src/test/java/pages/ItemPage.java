package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemPage extends BasePage {

    public Locator addButton;

    public Locator buyBlock;
    private final Logger log = LoggerFactory.getLogger(ItemPage.class);

    public ItemPage(Page page) {
        super(page);
        addButton = page.locator("#add_to_cart");
        buyBlock = page.locator("#buy_block");
    }

    @Step("Click on add button")
    public void clickAddButton() {
        addButton.hover();
        addButton.click();
        log.info("Click on add button");
    }
}
