package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import helpers.CreateRandomData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.components.MenuComponent;

public class HomePage extends BasePage {

    private CreateRandomData createRandomData = new CreateRandomData();

    public Locator blockPopularSellers;
    public Locator randomPopularItem;
    public Locator searchBar;
    public Locator searchButton;

    public MenuComponent menuComponent;

    private final Logger log = LoggerFactory.getLogger(HomePage.class);

    public HomePage(Page page) {
        super(page);
        menuComponent = new MenuComponent(page);
        blockPopularSellers = page.locator("#homefeatured");
        searchBar = page.locator("#search_query_top");
        searchButton = page.locator("button.button-search");
    }

    public void selectRandomPopularItem() {
        int numberOfPopularElements = blockPopularSellers.locator(">li").count();
        log.info(numberOfPopularElements + " elements were found in popular section");
        int selectRandomElement = createRandomData.createRandomNumber(numberOfPopularElements);
        this.randomPopularItem = blockPopularSellers.locator(">:nth-child(" + selectRandomElement + ")");
        log.info("The element " + selectRandomElement + " was selected");
    }

    public void clickOnRandomPopularItem() {
        randomPopularItem.locator(".product-container").click();
        log.info("Click on the " + randomPopularItem + " element");
    }

    public void fillTheSearchBar(){
        log.info("Filling the Search bar");
        searchBar.fill("Blouse");
    }

    public void clickTheSearchButton(){
        log.info("Clicking the Search button");
        searchButton.click();
    }

}
