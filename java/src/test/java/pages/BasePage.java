package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class BasePage {
    private Page page;

    public BasePage(Page page) {
        this.page = page;
        this.page.setDefaultNavigationTimeout(30000);
        this.page.setDefaultTimeout(30000);
        PlaywrightAssertions.setDefaultAssertionTimeout(30000);
    }

    protected void assertIfLocatorIsVisible(Locator locator) {
        assertThat(locator).isVisible();
    }

    protected void assertIfLocatorIsEditable(Locator locator) {
        assertThat(locator).isEditable();
    }

    protected void assertThatElementContainsText(Locator locator, String text) {
        assertThat(locator).containsText(text);
    }

    protected void assertThatLocatorContainsCertainNumberOfElements(Locator locator, int numberOfElements) {
        assertThat(locator).hasCount(numberOfElements);
    }
}
