package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.components.MenuComponent;

public class HomePage extends BasePage {
    private Locator secondAnnounce;

    private Locator bestSellerButton;
    private Locator firstBestSellerOnList;

    public MenuComponent menuComponent;

    public HomePage(Page page) {
        super(page);
        menuComponent = new MenuComponent(page);
        secondAnnounce = page.locator("#htmlcontent_top > ul > li.htmlcontent-item-1.col-xs-4");
        bestSellerButton = page.locator("#home-page-tabs > li.active > a");
        firstBestSellerOnList = page.locator("#blockbestsellers > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line");
    }

    public void clickSecondAnnounce() {
        secondAnnounce.click();
    }

    public void clickOnBestSellers() {
        bestSellerButton.click();
    }

    public Locator getFirstBestSellerOnList() {
        return firstBestSellerOnList;
    }
}
