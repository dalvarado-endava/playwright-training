const { expect } = require('@playwright/test');

exports.MyAccountPage = class MyAccountPage {

  /**
   * @param {import('@playwright/test').Page} page
   */
  constructor(page) {
    this.page = page;
    this.myAccountH1 = this.page.locator('h1');
  }

  async validateMyAccountTitle(title) {
    await expect(this.page).toHaveTitle(title);
  }
  
  async validateMyAccountText(text){
    await expect(this.myAccountH1).toHaveText(text);
  }
  
}