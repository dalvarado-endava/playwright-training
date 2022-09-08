package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import helpers.CreateRandomData;

public class LoginPage extends BasePage{

    private Locator createAccountMail;
    private Locator createAccountButton;

    public LoginPage(Page page) {
        super(page);
        createAccountMail = page.locator("#email_create");
        createAccountButton = page.locator("#SubmitCreate");
    }

    public Locator getCreateAccountMail(){
        return createAccountMail;
    }

    public void fillCreateAccountEmail(){
        String email = new CreateRandomData().createRandomEmail();
        createAccountMail.fill(email);
    }

    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }
}
