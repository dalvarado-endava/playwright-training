package pages;

import com.microsoft.playwright.Page;
import pages.components.CartNavigation;
import pages.components.CartSummary;

public class Submit extends BasePage {

    public CartNavigation cartNavigation;
    public CartSummary cartSummary;

    public Submit(Page page) {
        super(page);
        cartNavigation = new CartNavigation(page);
        cartSummary = new CartSummary(page);
    }
}
