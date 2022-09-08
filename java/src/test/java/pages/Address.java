package pages;

import com.microsoft.playwright.Page;
import pages.components.CartNavigation;

public class Address extends BasePage {
    public CartNavigation cartNavigation;

    public Address(Page page) {
        super(page);
        cartNavigation = new CartNavigation(page);
    }
}
