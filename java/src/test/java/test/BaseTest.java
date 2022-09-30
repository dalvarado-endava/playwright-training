package test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import helpers.BrowserProvider;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import pages.components.AddPopup;
import pages.components.ItemPopup;


import java.io.ByteArrayInputStream;
import java.nio.file.Paths;
import java.util.UUID;

public class BaseTest {

    public Playwright playwright;
    public Browser browser;

    public Page page;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected CreateAnAccountPage createAnAccountPage;
    protected MyAccountPage myAccountPage;
    protected ItemPage itemPage;
    protected AddPopup addPopup;
    protected SearchPage searchPage;
    protected ItemPopup itemPopup;

    protected Submit submit;

    protected String userEmail;

    protected String userPassword;

    protected Address address;

    protected Shipping shipping;
    protected Payment payment;

    private BrowserProvider browserProvider = new BrowserProvider();

    @BeforeMethod
    @Parameters({"browserName"})
    public void set(@Optional("Firefox") String browserName) {
        playwright = Playwright.create();
        browser = browserProvider.getBrowser(playwright, browserName)
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("http://automationpractice.com/index.php?");
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
        payment = new Payment(page);
        searchPage = new SearchPage(page);
        itemPopup = new ItemPopup(page);
        Assert.assertNotNull(page);
    }

    @AfterMethod
    public void close(ITestResult result) {
        if (!result.isSuccess()) {
            String uuid = UUID.randomUUID().toString();
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("allure-results/screenshot" + uuid + "screenshot.png"))
                    .setFullPage(true));
            Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(screenshot));
        }
        browser.close();
        Assert.assertTrue(result.isSuccess());
    }

}