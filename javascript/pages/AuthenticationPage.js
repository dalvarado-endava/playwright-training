const { expect } = require('@playwright/test');
const { BasePage } = require('../pages/BasePage.js');

exports.AuthenticationPage = class AuthenticationPage extends BasePage{

    /**
     * @param {import('@playwright/test').Page} page
     */
    constructor(page) {
        super(page);
        this.registeredEmailErrorAlert = page.locator('#create_account_error');
        this.createEmailInput = page.locator('#email_create');
        this.loginEmailInput = page.locator('#email');
        this.loginPasswordInput = page.locator('#passwd');
        this.createAnAccountButton = page.locator('#SubmitCreate', { hasText: 'Create an account' });
        this.signInButton = page.locator('#SubmitLogin');
        this.authFailedErrorAlert = page.locator('.alert.alert-danger > ol > li');
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

    async validateAuthFailedError(message) {
        await expect(this.authFailedErrorAlert).toContainText(message);
    }

}