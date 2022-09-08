package test;

import org.testng.annotations.Test;
import resources.InitialSetup;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestCases extends InitialSetup {
    @Test
    public void LogIn(){
        homePage.menuComponent.clickOnSingInButton();
        assertThat(loginPage.getCreateAccountMail()).isEditable();
        loginPage.fillCreateAccountEmail();
        loginPage.clickOnCreateAccountButton();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createAnAccountPage.fillFirstName();
        createAnAccountPage.fillLastName();
        createAnAccountPage.fillEmail();
        createAnAccountPage.fillPassword();
        createAnAccountPage.fillAddress();
        createAnAccountPage.fillCity();
        //createAnAccountPage.selectState();
        createAnAccountPage.fillZip();
        createAnAccountPage.fillMobilePhone();
        createAnAccountPage.clickInRegisterButton();
        System.out.println("Sing button in thread "+ Thread.currentThread().getId());
    }
}
