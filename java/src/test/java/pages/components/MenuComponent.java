package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class MenuComponent extends BasePage {

    public Locator getSingButton() {
        return singButton;
    }

    private Locator singButton;
    private Locator singOut;

    private final Logger log = LoggerFactory.getLogger(MenuComponent.class);

    public MenuComponent(Page page) {
        super(page);
        singButton = page.locator(".header_user_info");
        singOut = page.locator(".logout");
    }

    public void clickOnSingInButton() {
        log.info("Clicking on Sing In button");
        singButton.click();
        log.info("The button was clicked");
    }

    public Locator getSingOut() {
        return singOut;
    }
}
