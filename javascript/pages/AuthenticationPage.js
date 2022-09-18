const { expect } = require('@playwright/test');

exports.AuthenticationPage = class AuthenticationPage {

    /**
     * @param {import('@playwright/test').Page} page
     */
    constructor(page) {
        this.page = page;
        this.registeredEmailErrorAlert = page.locator('#create_account_error');
        this.createEmailInput = page.locator('#email_create');
        this.loginEmailInput = page.locator('#email');
        this.loginPasswordInput = page.locator('#passwd');
        this.createAnAccountButton = page.locator('#SubmitCreate', { hasText: 'Create an account' });
        this.signInButton = page.locator('#SubmitLogin');
    }

    async fillEmail(email) {
        await this.createEmailInput.fill(email);
    }

    async typeLoginEmail(email){
        await this.loginEmailInput.fill(email);
    }

    async typeLoginPassword(password){
        await this.loginPasswordInput.fill(password);
    }

    async clickCreateAnAccountButton() {
        await this.createAnAccountButton.click();
    }

    async clickSignInButton() {
        await this.signInButton.click();
    }

    async validateRegisteredEmailError(message) {
        await expect(this.registeredEmailErrorAlert).toContainText(message);
    }

}