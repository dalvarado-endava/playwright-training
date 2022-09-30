package test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class RegisterAndLogin extends BaseTest {
    @Test
    @Feature("Login and register")
    @Description("As user I want to click on sing button and create a new user in the platform")
    public void LogIn() {
        homePage.menuComponent.clickOnSingInButton();
        loginPage.assertThatCreateAccountMailIsEditable();
        loginPage.fillCreateAccountEmail();
        loginPage.assertThatCreateAccountButtonIsVisible();
        loginPage.clickOnCreateAccountButton();
        createAnAccountPage.assertThatFirstNameIsEditable();
        createAnAccountPage.fillFirstName();
        createAnAccountPage.assertThatLastNameIsEditable();
        createAnAccountPage.fillLastName();
        createAnAccountPage.assertThatEmailIsEditable();
        createAnAccountPage.fillEmail();
        createAnAccountPage.assertThatPasswordIsEditable();
        createAnAccountPage.fillPassword();
        createAnAccountPage.assertThatAddressIsEditable();
        createAnAccountPage.fillAddress();
        createAnAccountPage.assertThatCityIsEditable();
        createAnAccountPage.fillCity();
        createAnAccountPage.assertThatStateDropDownIsVisible();
        createAnAccountPage.selectState();
        createAnAccountPage.assertThatZipCodeIsEditable();
        createAnAccountPage.fillZip();
        createAnAccountPage.assertThatMobilePhoneIsEditable();
        createAnAccountPage.fillMobilePhone();
        createAnAccountPage.clickInRegisterButton();
        myAccountPage.assertThatMyPersonalInformationButtonIsVisible();
    }

}
