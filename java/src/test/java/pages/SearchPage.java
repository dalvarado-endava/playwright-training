package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchPage extends BasePage{

    private Locator nameSearch;
    private Locator pictureOfTheFirstItem;

    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public SearchPage(Page page){
        super(page);
        nameSearch = page.locator(".lighter");
        pictureOfTheFirstItem = page.locator(".left-block");
    }

    public Locator getSearch(){
        log.info("Getting the search");
        return nameSearch;
    }

    public void clickOnTheFirstItem(){
        log.info("Clicking on the first item");
        pictureOfTheFirstItem.click();
    }
}
