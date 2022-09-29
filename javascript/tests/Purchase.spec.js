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
const calculate = require('../helpers/calculate.js');

let authenticationPage;
let womenPage;
let productPage;
let productModal;
let orderPage;
let addressPage;
let shippingPage;
let paymentPage;

test.describe('Purchase while logged in', () => {

    test.beforeEach(async ({ page }) => {
        womenPage = new WomenPage(page);
        productPage = new ProductPage(page);
        productModal = new ProductModal(page);
        orderPage = new OrderPage(page);
        authenticationPage = new AuthenticationPage(page);
        addressPage = new AddressPage(page);
        shippingPage = new ShippingPage(page);
        paymentPage = new PaymentPage(page);
        await authenticationPage.goToPage();
        await authenticationPage.typeLoginEmail(process.env.EMAIL);
        await authenticationPage.typeLoginPassword(process.env.PASSWORD);
        await authenticationPage.clickSignInButton();
    });
    
    data.products.women.forEach((product,index) => {
        test(`Purchase women clothes: ${product.name} (${product.price})`, async ({ page }) => {
            await womenPage.goToPage();
            await womenPage.validateTitle(data.titles.womenpage);
            await womenPage.hoverProduct(index);
            await womenPage.clickMoreButton(index);
            await productPage.fillWantedQuantity(product.quantity);
            await productPage.clickAddToCartButton();
            await productModal.validateProductAddedMessage(data.texts.productAdded);
            await productModal.validateProductName(product.name);
            await productModal.validateProductQuantity(product.quantity);
            await productModal.clickCheckoutButton();
            await orderPage.validateTitle(data.titles.orderPage);
            await orderPage.clickCheckoutButton();
            await addressPage.clickCheckoutButton();
            await shippingPage.checkTermsOfService();
            await shippingPage.clickCheckoutButton();
            await paymentPage.validateTotal( calculate.totalPrice(product.price, product.quantity) );
            await paymentPage.clickBankwireButton();
            await paymentPage.validateBankwireHeading(data.texts.bankwirePayment);
            await paymentPage.clickConfirmOrderButton();
            await paymentPage.validateOrderConfirmation(data.texts.orderConfirmation);
        });

    })
});
