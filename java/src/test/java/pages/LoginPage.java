package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import helpers.CreateRandomData;

public class LoginPage extends BasePage{

    private Locator createAccountMail;
    private Locator createAccountButton;

    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(Page page) {
        super(page);
        createAccountMail = page.locator("#email_create");
        createAccountButton = page.locator("#SubmitCreate");
    }

    public Locator getCreateAccountMail(){
        return createAccountMail;
    }

    public void fillCreateAccountEmail(){
        log.info("Filling the email in Login page");
        String email = new CreateRandomData().createRandomEmail();
        createAccountMail.fill(email);
        log.info("The email in the Login page was filled with: {}",email);
    }

    public void clickOnCreateAccountButton(){
        log.info("Clicking on Create Account button in Login Page");
        createAccountButton.click();
    }
}
