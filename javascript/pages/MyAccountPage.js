const { expect } = require('@playwright/test');
const data = require('../data/data.json');

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

  async validateRandomUserName(accountCreationPage) {
    await expect(this.userButton).toContainText(data.user.firstname + " " + data.user.lastname);
  }

  async validateUsername(){
    await expect(this.userButton).toContainText(process.env.FIRSTNAME + " " + process.env.LASTNAME);
  }

}