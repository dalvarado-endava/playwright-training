const { expect } = require('@playwright/test');

exports.ProductModal = class ProductModal {

    /**
     * @param {import('@playwright/test').Page} page 
     */
    constructor(page){
        this.page = page;
        this.layerCartDiv = this.page.locator('#layer_cart');
        this.productAddedText = this.page.locator('#layer_cart .layer_cart_product h2');
        this.productNameText = this.page.locator('#layer_cart_product_title');
        this.productQuantityText = this.page.locator('#layer_cart_product_quantity');
        this.checkoutButton = this.page.locator('.btn.btn-default.button.button-medium');
    }

    async validateProductAddedMessage(message){
        await expect(this.layerCartDiv).toBeVisible();
        await expect(this.productAddedText).toContainText(message);
    }

    async validateProductName(productName){
        await expect(this.productNameText).toContainText(productName);
    }

    async validateProductQuantity(quantity){
        await expect(this.productQuantityText).toContainText(quantity);
    }

    async clickCheckoutButton(){
        await this.checkoutButton.click();
    }
}