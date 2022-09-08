package pages;

import com.microsoft.playwright.Page;
import pages.components.CartNavigation;

public class Submit extends BasePage{

    public CartNavigation cartNavigation;

    public Submit(Page page) {
        super(page);
        cartNavigation = new CartNavigation(page);
    }
}
