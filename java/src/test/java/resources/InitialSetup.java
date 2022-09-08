package resources;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.*;
import pages.CreateAnAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class InitialSetup {
    protected Playwright playwright;
    protected Page page;
    protected Browser browser;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected CreateAnAccountPage createAnAccountPage;
    protected MyAccountPage myAccountPage;


    @BeforeMethod
    public void openBrowser() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        browser = playwright.chromium().launch(lp);
        page = browser.newPage();
        page.navigate("http://automationpractice.com/index.php");
        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
        createAnAccountPage = new CreateAnAccountPage(page);
        myAccountPage = new MyAccountPage(page);
    }

    @AfterMethod
    public void close(){
        browser.close();
        playwright.close();
    }

}
