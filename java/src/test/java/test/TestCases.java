package test;

import org.testng.annotations.Test;
import pages.MyAccountPage;
import resources.InitialSetup;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestCases extends InitialSetup {
    @Test
    public void LogIn(){
        homePage.menuComponent.clickOnSingInButton();
        assertThat(loginPage.getCreateAccountMail()).isEditable();
        loginPage.fillCreateAccountEmail();
        loginPage.clickOnCreateAccountButton();
        assertThat(createAnAccountPage.getCustomerFirstName()).isVisible();
        createAnAccountPage.fillFirstName();
        createAnAccountPage.fillLastName();
        createAnAccountPage.fillEmail();
        createAnAccountPage.fillPassword();
        createAnAccountPage.fillAddress();
        createAnAccountPage.fillCity();
        createAnAccountPage.selectState();
        createAnAccountPage.fillZip();
        createAnAccountPage.fillMobilePhone();
        createAnAccountPage.clickInRegisterButton();
        assertThat(myAccountPage.getMyPersonalInformationButton()).isVisible();
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sing button in thread "+ Thread.currentThread().getId());
    }
}
