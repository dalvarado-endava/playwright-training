const { expect } = require('@playwright/test');

exports.ProductPage = class ProductPage {

    /**
     * @param {import('@playwright/test').Page} page 
     */
    constructor(page) {
        this.page = page;
        this.productName = this.page.locator('h1');
        this.wantedQuantityInput = this.page.locator('#quantity_wanted');
        this.addToCartButton = this.page.locator('#add_to_cart');
    }

    async validateProductName(productName){
        await expect(this.productName).toHaveText(productName);
    }

    async fillWantedQuantity(quantity){
        await this.wantedQuantityInput.fill(quantity);
    }

    async clickAddToCartButton(){
        await this.addToCartButton.click();
    }

}