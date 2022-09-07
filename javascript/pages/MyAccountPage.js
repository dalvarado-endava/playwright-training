const { expect } = require('@playwright/test');

exports.MyAccountPage = class MyAccountPage {

  /**
   * @param {import('@playwright/test').Page} page
   */
  constructor(page) {
    this.page = page;
    this.myAccountH1 = this.page.locator('h1');
    this.userButton = this.page.locator('.header_user_info span');
  }

  async validateMyAccountTitle() {
    await expect(this.page).toHaveTitle('My account - My Store');
    await expect(this.myAccountH1).toHaveText('My account');
  }

  async validateUserName(accountCreationPage) {
    await expect(this.userButton).toBeVisible();
    await expect(this.userButton).toContainText(accountCreationPage.firstName + " " + accountCreationPage.lastName);
  }

}