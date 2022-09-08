package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import helpers.CreateRandomData;

public class LoginPage extends BasePage {

    private Locator createAccountMail;
    private Locator singInMail;
    private Locator singInPassword;
    private Locator singInButton;
    private Locator createAccountButton;

    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(Page page) {
        super(page);
        createAccountMail = page.locator("#email_create");
        createAccountButton = page.locator("#SubmitCreate");
        singInMail = page.locator("#email");
        singInPassword = page.locator("#passwd");
        singInButton = page.locator("#SubmitLogin");
    }

    public Locator getCreateAccountMail() {
        return createAccountMail;
    }

    public void fillCreateAccountEmail() {
        log.info("Filling the email in Login page");
        String email = new CreateRandomData().createRandomEmail();
        createAccountMail.fill(email);
        log.info("The email in the Login page was filled with: {}", email);
    }

    public void clickOnCreateAccountButton() {
        log.info("Clicking on Create Account button in Login Page");
        createAccountButton.click();
    }

    public void fillSingInMail(String email) {
        singInMail.fill(email);
        log.info("Fill the field email on Sing in with the email " + email);
    }

    public void fillSingInPassword(String password) {
        singInPassword.fill(password);
        log.info("Fill the password");
    }

    public Locator getCreateAccountButton() {
        return createAccountButton;
    }

    public void clickOnSingInButton() {
        singInButton.click();
        log.info("Click on Sing In button");
    }
}