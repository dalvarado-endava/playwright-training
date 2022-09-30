package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import pages.components.MenuComponent;

public class MyAccountPage extends BasePage {
    private final Locator myPersonalInformationButton;

    public MenuComponent menuComponent;

    public MyAccountPage(Page page) {
        super(page);
        menuComponent = new MenuComponent(page);
        myPersonalInformationButton = page.locator(".icon-user");
    }

    @Step("Assert that my personal information button is visible")
    public void assertThatMyPersonalInformationButtonIsVisible() {
        assertIfLocatorIsVisible(myPersonalInformationButton);
    }
}
