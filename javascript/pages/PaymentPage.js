const { expect } = require('@playwright/test');

exports.PaymentPage = class PaymentPage {

    /**
     * @param {import('@playwright/test').Page} page 
     */
    constructor(page) {
        this.page = page;
        this.totalPriceField = this.page.locator('#total_price');
        this.bankwireButton = this.page.locator('.payment_module>.bankwire');
        this.bankwireHeading = this.page.locator('.page-subheading');
        this.confirmOrderButton = this.page.locator('#cart_navigation>button');
        this.orderConfirmationHeading = this.page.locator('h1.page-heading');
    }

    async validateTotal(totalPrice){
        await expect(this.totalPriceField).toContainText(totalPrice);
    }

    async clickBankwireButton(){
        await this.bankwireButton.click();
    }

    async validateBankwireHeading(text){
        await expect(this.bankwireHeading).toContainText(text);
    }

    async clickConfirmOrderButton(){
        await this.confirmOrderButton.click()
    }

    async validateOrderConfirmation(text){
        await expect(this.orderConfirmationHeading).toHaveText(text);
    }
}