const { expect } = require('@playwright/test');

exports.WomenPage = class WomenPage {

    /**
     * @param {import('@playwright/test').Page} page 
     */
    constructor(page){
        this.page = page;
        this.url = 'http://automationpractice.com/index.php?id_category=3&controller=category'
        this.products = this.page.locator('.product_list.grid.row > li');
        this.moreButton = this.page.locator('.button.lnk_view.btn.btn-default', {hasText: 'More'})
        this.addToCartButton = this.page.locator('.button.ajax_add_to_cart_button.btn.btn-default');
    }

    async goToPage(){
        await this.page.goto(this.url);
    }    
    
    async validateTitle(title){
        await expect(this.page).toHaveTitle(title);
    }

    async hoverProduct(product) {
        await this.products.nth(product).scrollIntoViewIfNeeded();
        await this.products.nth(product).hover();
    }

    async clickMoreButton(product) {
        this.moreButton.nth(product).click();
    }

    // pending to use
    async clickAddToCartButton() {
        await this.addToCartButton.nth(1).click();
    }
}