const { test } = require('@playwright/test');
const { Homepage } = require('../pages/Homepage.js');
const { AuthenticationPage } = require('../pages/AuthenticationPage.js');
const { AccountCreationPage } = require('../pages/AccountCreationPage.js');
const { MyAccountPage } = require('../pages/MyAccountPage.js');
const { SearchPage } = require('../pages/SearchPage');
const { Header } = require('../pages/components/Header.js');
const { dotenv } = require('dotenv').config();
const data = require('../data/data.json');
const randomize = require('../helpers/randomize');


let homepage;
let header;
let authenticationPage;
let accountCreationPage;
let myAccountPage;
let searchPage;


test.describe('Registration and Login', () => {

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
        await authenticationPage.fillEmail(randomize.email());
        await authenticationPage.clickCreateAnAccountButton();
        await accountCreationPage.validatePageTitle(data.titles.loginpage);
        await accountCreationPage.fillCustomerFirstName(data.user.firstname)
        await accountCreationPage.fillCustomerLastName(data.user.lastname)
        await accountCreationPage.fillPassword(process.env.PASSWORD)
        await accountCreationPage.fillFirstName(data.user.firstname)
        await accountCreationPage.fillLastName(data.user.lastname)
        await accountCreationPage.fillAddress(data.user.address)
        await accountCreationPage.fillCity(data.user.city)
        await accountCreationPage.fillState(randomize.state())
        await accountCreationPage.fillPostCode(data.user.postcode)
        await accountCreationPage.fillMobilePhone(data.user.mobilephone)
        await accountCreationPage.clickRegisterButton();
        await myAccountPage.validateMyAccountTitle(data.titles.myaccountpage);
        await myAccountPage.validateMyAccountText(data.texts.myaccountpageH1);
        await header.validateRandomUserName(data.user.firstname, data.user.lastname);
    });

    test('Unsuccessful user registration', async ({ page }) => {
        await authenticationPage.fillEmail(process.env.EMAIL);
        await authenticationPage.clickCreateAnAccountButton();
        await authenticationPage.validateRegisteredEmailError(data.errors.registerEmailErrorMessage);
    });

    test('Successful login', async ({ page }) => {
        await authenticationPage.typeLoginEmail(process.env.EMAIL);
        await authenticationPage.typeLoginPassword(process.env.PASSWORD);
        await authenticationPage.clickSignInButton();
        await header.validateUsername(process.env.FIRSTNAME, process.env.LASTNAME);
    });

});


test.describe('Search', () => {

    test.beforeEach(async ({ page }) => {
        homepage = new Homepage(page);
        header = new Header(page);
        searchPage = new SearchPage(page);
        await homepage.gotoPage();
    });

    test('Search with results', async ({ page }) => {
        await header.typeKeywords(data.searches.yellowdress.keywords);
        await header.clickSearchButton();
        await searchPage.validateNumberOfResults(data.searches.yellowdress.results, data.texts.resultsFound);
    });

    test('Search with no results', async ({ page }) => {
        await header.typeKeywords(data.searches.labordress.keywords);
        await header.clickSearchButton();
        await searchPage.validateNoResultsFound(data.searches.labordress.results, data.errors.noSearchResultsFound);
    });

});

