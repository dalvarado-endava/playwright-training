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

    data.products.women.forEach((product, index) => {
        test(`Purchase Women clothes: ${product.name} (${product.price})`, async ({ page }) => {

            await test.step('Go to "Women" section Page', async () =>
                await womenPage.goToPage(data.urls.womenpage))

            await test.step('Validate "Women" section page title', async () =>
                await womenPage.validateTitle(data.titles.womenpage))

            await test.step(`Hover product`, async () =>
                await womenPage.hoverProduct(index))

            await test.step('Click "More" button of product', async () =>
                await womenPage.clickMoreButton(index))

            await test.step('Fill wanted quantity of the product', async () =>
                await productPage.fillWantedQuantity(product.quantity))

            await test.step('Click "Add To Cart" button', async () =>
                await productPage.clickAddToCartButton())

            await test.step('Validate "Product added" message', async () =>
                await productModal.validateProductAddedMessage(data.texts.productAdded))

            await test.step('Validate product name', async () =>
                await productModal.validateProductName(product.name))

            await test.step('Validate product quantity', async () =>
                await productModal.validateProductQuantity(product.quantity))

            await test.step('Click "Checkout" button', async () =>
                await productModal.clickCheckoutButton())

            await test.step('Validate "Order" page title', async () =>
                await orderPage.validateTitle(data.titles.orderPage))

            await test.step('Click "Checkout" button', async () =>
                await orderPage.clickCheckoutButton())

            await test.step('Click "Checkout" button', async () =>
                await addressPage.clickCheckoutButton())

            await test.step('Check "Terms Of Service" box', async () =>
                await shippingPage.checkTermsOfService())

            await test.step('Click "Checkout" button', async () =>
                await shippingPage.clickCheckoutButton())

            await test.step('Validate the purchase total', async () =>
                await paymentPage.validateTotal(calculate.totalPrice(product.price, product.quantity)))

            await test.step('Click "Bankwire" button', async () =>
                await paymentPage.clickBankwireButton())

            await test.step('Validate "Bankwire" heading', async () =>
                await paymentPage.validateBankwireHeading(data.texts.bankwirePayment))

            await test.step('Click "Confirm order" button', async () =>
                await paymentPage.clickConfirmOrderButton())

            await test.step('Validate order confirmation', async () =>
                await paymentPage.validateOrderConfirmation(data.texts.orderConfirmation))
        });

    })
});
