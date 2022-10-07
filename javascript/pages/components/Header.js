const { expect } = require('@playwright/test');

exports.Header = class Header {

    /**
     * @param {import('@playwright/test').Page} page 
     */
    constructor(page) {
        this.page = page;
        this.signInButton = this.page.locator('.login', { hasText: 'Sign in' });
        this.userButton = this.page.locator('.header_user_info span');
        this.searchInput = this.page.locator('#search_query_top');
        this.searchButton = this.page.locator('//button[@name="submit_search"]');
    }

    async clickSignInButton() {
        await this.signInButton.click();
    }

    async validateRandomUserName(firstname, lastname) {
        await expect(this.userButton).toContainText(firstname + " " + lastname);
    }

    async validateUsername(firstname, lastname) {
        await expect(this.userButton).toContainText(firstname + " " + lastname);
    }

    async typeKeywords(keywords) {
        await this.searchInput.fill(keywords);
    }

    async clickSearchButton() {
        await this.searchButton.click();
    }
}