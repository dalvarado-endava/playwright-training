const { expect } = require('@playwright/test');
const { BasePage } = require('../pages/BasePage.js');

exports.MyAccountPage = class MyAccountPage extends BasePage{

  /**
   * @param {import('@playwright/test').Page} page
   */
  constructor(page) {
    super(page);
    this.myAccountH1 = this.page.locator('h1');
  }
  
  async validateMyAccountText(text){
    await expect(this.myAccountH1).toHaveText(text);
  }
  
}