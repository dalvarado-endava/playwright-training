const { expect } = require('@playwright/test');

exports.OrderPage = class OrderPage {

    /**
     * @param {import('@playwright/test').Page} page 
     */
    constructor(page){
        this.page = page;
        this.checkoutButton = this.page.locator('//p/*[@title="Proceed to checkout"]');
    }

    async validateTitle(title) {
        await expect(this.page).toHaveTitle(title);
    }

    async clickCheckoutButton(){
        await this.checkoutButton.click();
    }

}