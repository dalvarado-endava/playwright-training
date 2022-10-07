const { expect } = require('@playwright/test');
const { BasePage } = require('./BasePage');

exports.SearchPage = class SearchPage extends BasePage {

    /**
     * @param {import('@playwright/test').Page} page 
     */
    constructor (page){
        super(page);
        this.searchResults = page.locator('.product_list.grid.row > li');
        this.noResultsFoundAlert = page.locator('.alert.alert-warning');
        this.headingCounterText = page.locator('.heading-counter');
    }

    async validateNumberOfResults(results, message){
        await expect(this.searchResults).toHaveCount(parseInt(results));
        await expect(this.headingCounterText).toContainText(results + message)
    }

    async validateNoResultsFound(results, message){
        await expect(this.searchResults).toHaveCount(parseInt(results));
        await expect(this.noResultsFoundAlert).toContainText(message);
    }
}