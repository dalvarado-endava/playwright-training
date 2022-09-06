package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.BasePage;

public class MenuComponent extends BasePage {

    private Locator singButton;


    public MenuComponent(Page page){
        super(page);
        singButton = page.locator(".header_user_info");
    }

    public void clickOnSingInButton(){
        singButton.click();
    }

}
