const { expect } = require('@playwright/test');

exports.AuthenticationPage = class AuthenticationPage {

    /**
     * @param {import('@playwright/test').Page} page
     */
    constructor(page) {
        this.page = page;
        this.email = 'fakeMail' + Math.floor(Math.random() * 9999) + '@mail.com';
        this.createEmailInput = page.locator('#email_create');
        this.createAnAccountButton = page.locator('#SubmitCreate', { hasText: 'Create an account' });
    }

    async typeEmail() {
        await expect(this.createEmailInput).toBeEditable();
        await this.createEmailInput.fill(this.email);
      }
    
      async clickCreateAnAccountButton() {
        await expect(this.createAnAccountButton).toBeVisible();
        await this.createAnAccountButton.click();
      }
}