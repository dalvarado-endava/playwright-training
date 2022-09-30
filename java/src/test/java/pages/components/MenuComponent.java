package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class MenuComponent extends BasePage {
    private final Locator singButton;
    private final Locator searchBar;
    private final Locator searchButton;
    private final Logger log = LoggerFactory.getLogger(MenuComponent.class);

    public MenuComponent(Page page) {
        super(page);
        singButton = page.locator(".header_user_info");
        searchButton = page.locator("button.button-search");
        searchBar = page.locator("#search_query_top");
    }

    @Step("Clicking on Sing In button")
    public void clickOnSingInButton() {
        log.info("Clicking on Sing In button");
        singButton.hover();
        singButton.click();
        log.info("The button was clicked");
    }

    @Step("assert that Search bar is visible")
    public void assertSearchBarIsVisible() {
        assertIfLocatorIsVisible(searchButton);
    }

    @Step("Clicking the Search button")
    public void clickTheSearchButton() {
        log.info("Clicking the Search button");
        searchButton.hover();
        searchButton.click();
    }

    @Step("Filling the Search bar")
    public void fillTheSearchBar(String search) {
        log.info("Filling the Search bar");
        searchBar.fill(search);
    }
}
