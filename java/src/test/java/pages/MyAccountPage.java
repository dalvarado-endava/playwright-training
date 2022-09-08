package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.components.MenuComponent;

public class MyAccountPage extends BasePage{
    private Locator myPersonalInformationButton;

    public MenuComponent menuComponent;

    public MyAccountPage(Page page) {
        super(page);
        menuComponent = new MenuComponent(page);
        myPersonalInformationButton = page.locator(".icon-user");
    }

    public Locator getMyPersonalInformationButton(){
        return myPersonalInformationButton;
    }
}
