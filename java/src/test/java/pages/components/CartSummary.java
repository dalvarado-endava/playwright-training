package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class CartSummary extends BasePage {
    public Locator productTable;
    private final Logger log = LoggerFactory.getLogger(CartSummary.class);

    public CartSummary(Page page) {
        super(page);
        productTable = page.locator("#cart_summary tbody > tr");
    }

    @Step("Click on trash icon")
    public void clickOnFirstTrashIcon() {
        productTable.locator("td").nth(6).hover();
        productTable.locator("td").nth(6).click();
        log.info("Click on trash icon");
    }

    @Step("Assert that proceed checkout button is visible")
    public void assertThatProductTableContainsNumberOfProducts(int numberOfProducts) {
        assertThatLocatorContainsCertainNumberOfElements(productTable, numberOfProducts);
    }

}
