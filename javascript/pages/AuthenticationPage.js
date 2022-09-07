const { expect } = require('@playwright/test');

exports.AuthenticationPage = class AuthenticationPage {

    /**
     * @param {import('@playwright/test').Page} page
     */
    constructor(page) {
        this.page = page;
        this.randomEmail = 'fakeMail' + Math.floor(Math.random() * 9999999) + '@mail.com';
        this.registeredEmail = 'asdf@mail.com';
        this.registeredEmailErrorMessage = 'An account using this email address has already been registered. Please enter a valid password or request a new one. ';
        this.registeredEmailErrorAlert = page.locator('#create_account_error');
        this.createEmailInput = page.locator('#email_create');
        this.createAnAccountButton = page.locator('#SubmitCreate', { hasText: 'Create an account' });
    }

    async typeRandomEmail() {
        await expect(this.createEmailInput).toBeEditable();
        await this.createEmailInput.fill(this.randomEmail);
    }

    async typeRegisteredEmail(){
        await expect(this.createEmailInput).toBeEditable();
        await this.createEmailInput.fill(this.registeredEmail);
    }

    async clickCreateAnAccountButton() {
        await expect(this.createAnAccountButton).toBeVisible();
        await this.createAnAccountButton.click();
    }

    async validateRegisteredEmailError() {
        await expect(this.registeredEmailErrorAlert).toBeVisible();
        await expect(this.registeredEmailErrorAlert).toContainText(this.registeredEmailErrorMessage);
    }

}