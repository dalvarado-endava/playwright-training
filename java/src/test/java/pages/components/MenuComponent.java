package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class MenuComponent extends BasePage {

    public Locator getSingButton() {
        return singButton;
    }

    private final Locator singButton;

    private final Logger log = LoggerFactory.getLogger(MenuComponent.class);

    public MenuComponent(Page page) {
        super(page);
        singButton = page.locator(".header_user_info");
    }

    @Step("Clicking on Sing In button")
    public void clickOnSingInButton() {
        log.info("Clicking on Sing In button");
        singButton.hover();
        singButton.click();
        log.info("The button was clicked");
    }
}
