package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import helpers.CreateRandomData;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.components.MenuComponent;

public class HomePage extends BasePage {
    private final Locator blockPopularSellers;
    private Locator randomPopularItem;

    private int randomNumberElement;
    public MenuComponent menuComponent;

    private Locator addButton;

    private final Logger log = LoggerFactory.getLogger(HomePage.class);

    public HomePage(Page page) {
        super(page);
        menuComponent = new MenuComponent(page);
        blockPopularSellers = page.locator("#homefeatured");
    }

    @Step("The random element was selected")
    public void selectRandomPopularItem() {
        int numberOfPopularElements = blockPopularSellers.locator(">li").count();
        log.info(numberOfPopularElements + " elements were found in popular section");
        randomNumberElement = new CreateRandomData().createRandomNumber(numberOfPopularElements);
        randomPopularItem = blockPopularSellers.locator(">:nth-child(" + randomNumberElement + ")");
        log.info("The element " + randomNumberElement + " was selected");
    }

    @Step("Click on random element")
    public void clickOnRandomPopularItem() {
        randomPopularItem.locator(".product-container").click();
        log.info("Click on the " + randomNumberElement + " element");
    }

    @Step("Pass mouse over random element")
    public void passMouseOverRandomItem() {
        randomPopularItem.locator(".product-container").hover();
        log.info("Pass mouse over the element " + randomNumberElement);
    }

    @Step("Get add button location")
    public Locator getAddButton() {
        addButton = randomPopularItem.locator(".button-container>> text=Add to cart");
        return addButton;
    }

    @Step("Click on Add button")
    public void clickOnAddButton() {
        addButton.click();
        log.info("Click on Add button");
    }

    @Step("Assert that Block Popular Sellers is visible")
    public void assertThatBlockPopularSellersIsVisible() {
        assertIfLocatorIsVisible(blockPopularSellers);
    }

    @Step("Assert that random popular item is visible")
    public void assertThatRandomPopularItemIsVisible() {
        assertIfLocatorIsVisible(randomPopularItem);
    }

    @Step("Assert that add button is visible")
    public void assertThatAddButtonIsVisible() {
        assertIfLocatorIsVisible(getAddButton());
    }

}