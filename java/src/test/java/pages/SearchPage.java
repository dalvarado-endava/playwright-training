package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchPage extends BasePage {

    private final Locator nameSearch;
    private final Locator pictureOfTheFirstItem;
    private final Locator addToCartButton;

    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public SearchPage(Page page) {
        super(page);
        nameSearch = page.locator(".lighter");
        pictureOfTheFirstItem = page.locator(".left-block > .product-image-container");
        addToCartButton = page.locator("text=Add to cart");
    }


    @Step("Clicking on the first item")
    public void passMouseOverTheFirstItem() {
        log.info("Clicking on the first item");
        pictureOfTheFirstItem.hover();
    }

    @Step("Click on add button")
    public void clickOnAddButton() {
        addToCartButton.click();
    }

    @Step("assert that add button is visible")
    public void assertThatAddButtonIsVisible() {
        assertIfLocatorIsVisible(addToCartButton);
    }

    @Step("assert that Search bar is visible")
    public void assertSearchResultsAreVisible() {
        assertIfLocatorIsVisible(nameSearch);
    }

}