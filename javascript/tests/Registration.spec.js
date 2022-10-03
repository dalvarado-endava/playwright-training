const { test } = require('@playwright/test');
const { Homepage } = require('../pages/Homepage.js');
const { AuthenticationPage } = require('../pages/AuthenticationPage.js');
const { AccountCreationPage } = require('../pages/AccountCreationPage.js');
const { MyAccountPage } = require('../pages/MyAccountPage.js');
const { Header } = require('../pages/components/Header.js');
const { dotenv } = require('dotenv').config();
const data = require('../data/data.json');
const randomize = require('../helpers/randomize.js');

let homepage;
let header;
let authenticationPage;
let accountCreationPage;
let myAccountPage;

test.describe('Registration', () => {

    test.beforeEach(async ({ page }) => {
        homepage = new Homepage(page);
        header = new Header(page);
        authenticationPage = new AuthenticationPage(page);
        accountCreationPage = new AccountCreationPage(page);
        myAccountPage = new MyAccountPage(page);
        await homepage.gotoPage();
        await header.clickSignInButton();
    });


    test('Successful user registration', async ({ page }) => {

        await test.step('Fill email field', async () =>
            await authenticationPage.fillEmail(randomize.email()))

        await test.step('Click "Create an account" button', async () =>
            await authenticationPage.clickCreateAnAccountButton())

        await test.step('Validate page title', async () =>
            await accountCreationPage.validatePageTitle(data.titles.loginpage))

        await test.step('Fill customer firstname field', async () =>
            await accountCreationPage.fillCustomerFirstName(data.user.firstname))

        await test.step('Fill customer lastname field', async () =>
            await accountCreationPage.fillCustomerLastName(data.user.lastname))

        await test.step('Fill password field', async () =>
            await accountCreationPage.fillPassword(process.env.PASSWORD))

        await test.step('Fill firstname field', async () =>
            await accountCreationPage.fillFirstName(data.user.firstname))

        await test.step('Fill lastname field', async () =>
            await accountCreationPage.fillLastName(data.user.lastname))

        await test.step('Fill address field', async () =>
            await accountCreationPage.fillAddress(data.user.address))

        await test.step('Fill city field', async () =>
            await accountCreationPage.fillCity(data.user.city))

        await test.step('Fill state field', async () =>
            await accountCreationPage.fillState(randomize.state()))

        await test.step('Fill postcode field', async () =>
            await accountCreationPage.fillPostCode(data.user.postcode))

        await test.step('Fill mobile phone field', async () =>
            await accountCreationPage.fillMobilePhone(data.user.mobilephone))

        await test.step('Click register button', async () =>
            await accountCreationPage.clickRegisterButton())

        await test.step('Validate "my account" title', async () =>
            await myAccountPage.validateMyAccountTitle(data.titles.myaccountpage))

        await test.step('Validate "my account" text', async () =>
            await myAccountPage.validateMyAccountText(data.texts.myaccountpageH1))

        await test.step('Validate random username', async () =>
            await header.validateRandomUserName(data.user.firstname, data.user.lastname))

    });

    test('Unsuccessful user registration', async ({ page }) => {

        await test.step('Fill email field', async () =>
            await authenticationPage.fillEmail(process.env.EMAIL))

        await test.step('Click "create an account" button', async () =>
            await authenticationPage.clickCreateAnAccountButton())

        await test.step('Validate registered email error message', async () =>
            await authenticationPage.validateRegisteredEmailError(data.errors.registerEmailErrorMessage))

    });

});
