package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;


public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
        this.page.setDefaultNavigationTimeout(60000);
        this.page.setDefaultTimeout(60000);
        PlaywrightAssertions.setDefaultAssertionTimeout(60000);
    }


}
