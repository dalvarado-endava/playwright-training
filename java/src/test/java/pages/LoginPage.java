package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import helpers.CreateRandomData;

public class LoginPage extends BasePage {

    private final Locator createAccountMail;
    private final Locator singInMail;
    private final Locator singInPassword;
    private final Locator singInButton;
    private final Locator createAccountButton;

    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(Page page) {
        super(page);
        createAccountMail = page.locator("#email_create");
        createAccountButton = page.locator("#SubmitCreate");
        singInMail = page.locator("#email");
        singInPassword = page.locator("#passwd");
        singInButton = page.locator("#SubmitLogin");
    }

    @Step("Get create account location")
    public Locator getCreateAccountMail() {
        return createAccountMail;
    }

    @Step("Filling the email in Login page")
    public void fillCreateAccountEmail() {
        log.info("Filling the email in Login page");
        String email = new CreateRandomData().createRandomEmail();
        createAccountMail.fill(email);
        log.info("The email in the Login page was filled with: {}", email);
    }

    @Step("Clicking on Create Account button in Login Page")
    public void clickOnCreateAccountButton() {
        log.info("Clicking on Create Account button in Login Page");
        createAccountButton.click();
    }

    @Step("Fill the field email on Sing in with the email {0}")
    public void fillSingInMail(String email) {
        singInMail.fill(email);
        log.info("Fill the field email on Sing in with the email " + email);
    }

    @Step("Fill the password")
    public void fillSingInPassword(String password) {
        singInPassword.fill(password);
        log.info("Fill the password");
    }

    @Step("Get create account button")
    public Locator getCreateAccountButton() {
        return createAccountButton;
    }

    @Step("Click on Sing In button")
    public void clickOnSingInButton() {
        singInButton.hover();
        singInButton.click();
        log.info("Click on Sing In button");
    }

    @Step("Assert that create account mail field is editable")
    public void assertThatCreateAccountMailIsEditable() {
        assertIfLocatorIsEditable(createAccountMail);
    }

    @Step("Assert that create account button is visible")
    public void assertThatCreateAccountButtonIsVisible() {
        assertIfLocatorIsVisible(createAccountButton);
    }
}