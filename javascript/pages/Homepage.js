const { expect } = require('@playwright/test');

exports.Homepage = class Homepage {

  /**
   * @param {import('@playwright/test').Page} page
   */
  constructor(page) {
    this.page = page;
    this.signInButton = page.locator('.login', { hasText: 'Sign in'});
    this.email = 'fakeMail'+ Math.floor(Math.random() * 9999) + '@mail.com';
    this.createEmailInput = page.locator('#email_create');
    this.createAnAccountButton = page.locator('#SubmitCreate',{hasText: 'Create an account'});
  }

  async gotoPage() {
    await this.page.goto('http://automationpractice.com/index.php');
    await expect(this.page).toHaveTitle('My Store');
  }

  async clickSignInButton() {
    await expect(this.signInButton).toBeVisible();
    await this.signInButton.click();
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