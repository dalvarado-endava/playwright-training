const { BasePage } = require('./BasePage.js');

exports.WomenPage = class WomenPage extends BasePage {

    /**
     * @param {import('@playwright/test').Page} page 
     */
    constructor(page){
        super(page);
        this.products = this.page.locator('.product_list.grid.row > li');
        this.moreButton = this.page.locator('.button.lnk_view.btn.btn-default', {hasText: 'More'})
        this.addToCartButton = this.page.locator('.button.ajax_add_to_cart_button.btn.btn-default');
    }

    async hoverProduct(product) {
        await this.products.nth(product).scrollIntoViewIfNeeded();
        await this.products.nth(product).hover();
    }

    async clickMoreButton(product) {
        this.moreButton.nth(product).click();
    }

}