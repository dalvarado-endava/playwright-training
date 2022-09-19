const { expect } = require('@playwright/test');

exports.ShippingPage = class ShippingPage {


    constructor(page){
        this.page = page;
        this.agreeTermsCheckbox = this.page.locator('#cgv');
        this.checkoutButton = this.page.locator('.cart_navigation button')
    }

    async checkTermsOfService(){
        await this.agreeTermsCheckbox.click();
    }

    async clickCheckoutButton(){
        await this.checkoutButton.click();
    }
}