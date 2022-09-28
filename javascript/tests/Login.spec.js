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

test.describe('Login', () => {

    test.beforeEach(async ({ page }) => {
        homepage = new Homepage(page);
        header = new Header(page);
        authenticationPage = new AuthenticationPage(page);
        accountCreationPage = new AccountCreationPage(page);
        myAccountPage = new MyAccountPage(page);
        await homepage.gotoPage();
        await header.clickSignInButton();
    });

    test('Successful login', async ({ page }) => {
        await authenticationPage.typeLoginEmail(process.env.EMAIL);
        await authenticationPage.typeLoginPassword(process.env.PASSWORD);
        await authenticationPage.clickSignInButton();
        await header.validateUsername(process.env.FIRSTNAME, process.env.LASTNAME);
    });

    test('Unsuccessful login', async ({ page }) => {
        await authenticationPage.typeLoginEmail(process.env.EMAIL);
        await authenticationPage.typeLoginPassword(randomize.password());
        await authenticationPage.clickSignInButton();
        await authenticationPage.validateAuthFailedError(data.errors.authFailedErrorMessage);
    });

});
