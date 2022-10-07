const { expect } = require('@playwright/test');

exports.AddressPage = class AddressPage {

    /**
     * @param {import('@playwright/test').Page} page 
     */
    constructor(page){
        this.page = page;
        this.checkoutButton = this.page.locator('.cart_navigation button')
    }

    async clickCheckoutButton() {
        await this.checkoutButton.click();
    }
}