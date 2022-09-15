const { expect } = require('@playwright/test');
const { dotenv } = require('dotenv').config();


exports.AuthenticationPage = class AuthenticationPage {

    /**
     * @param {import('@playwright/test').Page} page
     */
    constructor(page) {
        this.page = page;
        this.randomEmail = 'fakeMail' + Math.floor(Math.random() * 9999999) + '@mail.com';
        this.registeredEmailErrorMessage = 'An account using this email address has already been registered. Please enter a valid password or request a new one. ';
        this.registeredEmailErrorAlert = page.locator('#create_account_error');
        this.createEmailInput = page.locator('#email_create');
        this.loginEmailInput = page.locator('#email');
        this.loginPasswordInput = page.locator('#passwd');
        this.createAnAccountButton = page.locator('#SubmitCreate', { hasText: 'Create an account' });
        this.signInButton = page.locator('#SubmitLogin');
    }

    async typeRandomEmail() {
        await this.createEmailInput.fill(this.randomEmail);
    }

    async typeRegisteredEmail(){
        await this.createEmailInput.fill(process.env.EMAIL);
    }

    async typeLoginEmail(){
        await this.loginEmailInput.fill(process.env.EMAIL);
    }

    async typeLoginPassword(){
        await this.loginPasswordInput.fill(process.env.PASSWORD);
    }

    async clickCreateAnAccountButton() {
        await this.createAnAccountButton.click();
    }

    async clickSignInButton() {
        await this.signInButton.click();
    }

    async validateRegisteredEmailError() {
        await expect(this.registeredEmailErrorAlert).toContainText(this.registeredEmailErrorMessage);
    }

}