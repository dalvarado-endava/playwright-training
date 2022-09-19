const { test } = require('@playwright/test');
const { Homepage } = require('../pages/Homepage.js');
const { AuthenticationPage } = require('../pages/AuthenticationPage.js');
const { AccountCreationPage } = require('../pages/AccountCreationPage.js');
const { MyAccountPage } = require('../pages/MyAccountPage.js');
const { SearchPage } = require('../pages/SearchPage.js');
const { WomenPage } = require('../pages/WomenPage.js');
const { ProductPage } = require('../pages/ProductPage.js');
const { ProductModal } = require('../pages/components/ProductModal.js');
const { OrderPage } = require('../pages/OrderPage.js');
const { AddressPage } = require('../pages/AddressPage.js');
const { ShippingPage } = require('../pages/ShippingPage.js');
const { PaymentPage } = require('../pages/PaymentPage.js');
const { Header } = require('../pages/components/Header.js');
const { dotenv } = require('dotenv').config();
const data = require('../data/data.json');
const randomize = require('../helpers/randomize.js');


let homepage;
let header;
let authenticationPage;
let accountCreationPage;
let myAccountPage;
let searchPage;
let womenPage;
let productPage;
let productModal;
let orderPage;
let addressPage;
let shippingPage;
let paymentPage;


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


test.describe('Purchase while not logged in', () => {

    test.beforeEach(async ({ page }) => {
        womenPage = new WomenPage(page);
        productPage = new ProductPage(page);
        productModal = new ProductModal(page);
        orderPage = new OrderPage(page);
        authenticationPage = new AuthenticationPage(page);
        addressPage = new AddressPage(page);
        shippingPage = new ShippingPage(page);
        paymentPage = new PaymentPage(page);
        await womenPage.goToPage();
    });

    test('Purchase women clothes', async ({ page }) => {
        await womenPage.validateTitle(data.titles.womenpage);
        await womenPage.hoverProduct(data.products.women.blouse.index);
        await womenPage.clickMoreButton(data.products.women.blouse.index);
        await productPage.validateProductName(data.products.women.blouse.name);
        await productPage.fillWantedQuantity(data.products.women.blouse.quantity);
        await productPage.clickAddToCartButton();
        await productModal.validateProductAddedMessage(data.texts.productAdded);
        await productModal.validateProductName(data.products.women.blouse.name);
        await productModal.validateProductQuantity(data.products.women.blouse.quantity);
        await productModal.clickCheckoutButton();
        await orderPage.validateTitle(data.titles.orderPage);
        await orderPage.clickCheckoutButton();
        await authenticationPage.typeLoginEmail(process.env.EMAIL);
        await authenticationPage.typeLoginPassword(process.env.PASSWORD);
        await authenticationPage.clickSignInButton();
        await addressPage.clickCheckoutButton();
        await shippingPage.checkTermsOfService();
        await shippingPage.clickCheckoutButton();
        await paymentPage.validateTotal(data.products.women.blouse.total);
        await paymentPage.clickBankwireButton();
        await paymentPage.validateBankwireHeading(data.texts.bankwirePayment);
        await paymentPage.clickConfirmOrderButton();
        await paymentPage.validateOrderConfirmation(data.texts.orderConfirmation);
    });
});
