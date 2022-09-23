package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import helpers.CreateRandomData;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.components.MenuComponent;

public class HomePage extends BasePage {
    public Locator blockPopularSellers;
    public Locator randomPopularItem;
    public Locator searchBar;
    public Locator searchButton;

    private final int actualNumberElement;
    private int randomNumberElement;
    public MenuComponent menuComponent;

    private Locator addButton;

    private final Logger log = LoggerFactory.getLogger(HomePage.class);

    public HomePage(Page page) {
        super(page);
        menuComponent = new MenuComponent(page);
        blockPopularSellers = page.locator("#homefeatured");
        actualNumberElement = 0;
        searchBar = page.locator("#search_query_top");
        searchButton = page.locator("button.button-search");
    }

    @Step("The random element was selected")
    public void selectRandomPopularItem() {
        int numberOfPopularElements = blockPopularSellers.locator(">li").count();
        log.info(numberOfPopularElements + " elements were found in popular section");
        this.randomNumberElement = new CreateRandomData().createRandomNumber(numberOfPopularElements);
        this.randomPopularItem = blockPopularSellers.locator(">:nth-child(" + randomNumberElement + ")");
        log.info("The element " + randomNumberElement + " was selected");
    }

    @Step("Click on random element")
    public void clickOnRandomPopularItem() {
        this.randomPopularItem.locator(".product-container").click();
        log.info("Click on the " + this.randomNumberElement + " element");
    }

    @Step("Pass mouse over random element")
    public void passMouseOverRandomItem() {
        this.randomPopularItem.locator(".product-container").hover();
        log.info("Pass mouse over the element " + this.randomNumberElement);
    }
    @Step("Get add button location")
    public Locator getAddButton() {
        this.addButton = this.randomPopularItem.locator(".button-container>> text=Add to cart");
        return addButton;
    }

    @Step("Click on Add button")
    public void clickOnAddButton() {
        this.addButton.hover();
        this.addButton.click();
        log.info("Click on Add button");
    }

    @Step("Filling the Search bar")
    public void fillTheSearchBar() {
        log.info("Filling the Search bar");
        searchBar.fill("Blouse");
    }

    @Step("Clicking the Search button")
    public void clickTheSearchButton() {
        log.info("Clicking the Search button");
        searchButton.hover();
        searchButton.click();
    }

}
