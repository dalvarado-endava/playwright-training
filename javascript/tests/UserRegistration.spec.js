const { test } = require('@playwright/test');
const { Homepage } = require('../pages/Homepage.js');
const { AuthenticationPage } = require('../pages/AuthenticationPage.js');
const { AccountCreationPage } = require('../pages/AccountCreationPage.js');
const { MyAccountPage } = require('../pages/MyAccountPage.js');

test.describe('Registration and Login tests', () => {

    let homepage;
    let authenticationPage;
    let accountCreationPage;
    let myAccountPage;

    test.beforeEach(async ({ page }) => {
        homepage = new Homepage(page);
        authenticationPage = new AuthenticationPage(page);
        accountCreationPage = new AccountCreationPage(page);
        myAccountPage = new MyAccountPage(page);
        await homepage.gotoPage();
        await homepage.clickSignInButton();
    });

    test.only('Successful user registration', async ({ page }) => {
        await authenticationPage.typeRandomEmail();
        await authenticationPage.clickCreateAnAccountButton();
        await accountCreationPage.fillRequiredInputs();
        await accountCreationPage.clickRegisterButton();
        await myAccountPage.validateMyAccountTitle();
        await myAccountPage.validateRandomUserName(accountCreationPage);
    });

    test('Unsuccessful user registration', async ({ page }) => {
        await authenticationPage.typeRegisteredEmail();
        await authenticationPage.clickCreateAnAccountButton();
        await authenticationPage.validateRegisteredEmailError();
    });

    test('Successful login', async ({ page }) => {
        await authenticationPage.typeLoginEmail();
        await authenticationPage.typeLoginPassword();
        await authenticationPage.clickSignInButton();
        await myAccountPage.validateUsername();
    });

});


