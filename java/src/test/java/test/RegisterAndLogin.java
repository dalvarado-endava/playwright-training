package test;

import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterAndLogin extends BaseTest {
    @Test
    public void LogIn(){
        assertThat(homePage.menuComponent.getSingButton()).isVisible();
        homePage.menuComponent.clickOnSingInButton();
        assertThat(loginPage.getCreateAccountMail()).isEditable();
        loginPage.fillCreateAccountEmail();
        assertThat(loginPage.getCreateAccountButton()).isVisible();
        loginPage.clickOnCreateAccountButton();
        assertThat(createAnAccountPage.getCustomerFirstName()).isVisible();
        createAnAccountPage.fillFirstName();
        assertThat(createAnAccountPage.getLastName()).isEditable();
        createAnAccountPage.fillLastName();
        assertThat(createAnAccountPage.getEmail()).isEditable();
        createAnAccountPage.fillEmail();
        assertThat(createAnAccountPage.getPassword()).isEditable();
        createAnAccountPage.fillPassword();
        assertThat(createAnAccountPage.getAddress()).isEditable();
        createAnAccountPage.fillAddress();
        assertThat(createAnAccountPage.getCity()).isEditable();
        createAnAccountPage.fillCity();
        assertThat(createAnAccountPage.getStateDropDownMenu()).isVisible();
        createAnAccountPage.selectState();
        assertThat(createAnAccountPage.getZip()).isEditable();
        createAnAccountPage.fillZip();
        assertThat(createAnAccountPage.getMobilePhone()).isEditable();
        createAnAccountPage.fillMobilePhone();
        createAnAccountPage.clickInRegisterButton();
        assertThat(myAccountPage.getMyPersonalInformationButton()).isVisible();
    }

}
