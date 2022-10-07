const { expect } = require('@playwright/test');
const { BasePage } = require('../pages/BasePage.js');

exports.OrderPage = class OrderPage extends BasePage{

    /**
     * @param {import('@playwright/test').Page} page 
     */
    constructor(page){
        super(page);
        this.checkoutButton = this.page.locator('//p/*[@title="Proceed to checkout"]');
    }

    async clickCheckoutButton(){
        await this.checkoutButton.click();
    }

}