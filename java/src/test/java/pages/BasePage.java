package pages;

import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
        this.page.setDefaultNavigationTimeout(6000);
        this.page.setDefaultTimeout(6000);
    }


}
