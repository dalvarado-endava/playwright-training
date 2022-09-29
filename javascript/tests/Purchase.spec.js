const { test } = require('@playwright/test');
const { AuthenticationPage } = require('../pages/AuthenticationPage.js');
const { WomenPage } = require('../pages/WomenPage.js');
const { ProductPage } = require('../pages/ProductPage.js');
const { ProductModal } = require('../pages/components/ProductModal.js');
const { OrderPage } = require('../pages/OrderPage.js');
const { AddressPage } = require('../pages/AddressPage.js');
const { ShippingPage } = require('../pages/ShippingPage.js');
const { PaymentPage } = require('../pages/PaymentPage.js');
const { dotenv } = require('dotenv').config();
const data = require('../data/data.json');

let authenticationPage;
let womenPage;
let productPage;
let productModal;
let orderPage;
let addressPage;
let shippingPage;
let paymentPage;

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
