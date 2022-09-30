const { expect } = require('@playwright/test');

exports.BasePage = class BasePage {

    /**
     * @param {import('@playwright/test').Page} page 
     */
    constructor(page){
        this.page = page;
    }

    async goToPage(url){
        await this.page.goto(url);
    }    
    
    async validateTitle(title){
        await expect(this.page).toHaveTitle(title);
    }

}