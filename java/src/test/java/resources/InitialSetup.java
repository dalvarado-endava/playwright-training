package resources;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.*;
import pages.*;
import pages.components.AddPopup;

public class InitialSetup {
    protected Playwright playwright;
    protected Page page;
    protected Browser browser;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected CreateAnAccountPage createAnAccountPage;
    protected MyAccountPage myAccountPage;
    protected ItemPage itemPage;
    protected AddPopup addPopup;

    protected Submit submit;

    protected String userEmail;

    protected String userPassword;

    protected Address address;

    protected Shipping shipping;
    protected Payment payment;

    @BeforeMethod
    public void openBrowser() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        browser = playwright.chromium().launch(lp);
        page = browser.newPage();
        page.navigate("https://automationpractice.com/index.php?");
        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
        createAnAccountPage = new CreateAnAccountPage(page);
        myAccountPage = new MyAccountPage(page);
        itemPage = new ItemPage(page);
        addPopup = new AddPopup(page);
        submit = new Submit(page);
        userEmail = System.getenv("userEmail");
        userPassword = System.getenv("userPassword");
        address = new Address(page);
        shipping = new Shipping(page);
        payment = new Payment(page);
    }

    @AfterMethod
    public void close(){
        browser.close();
        playwright.close();
    }

}
