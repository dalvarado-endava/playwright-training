const { expect } = require('@playwright/test');

exports.Homepage = class Homepage {

  /**
   * @param {import('@playwright/test').Page} page
   */
  constructor(page) {
    this.page = page;
  }

  async gotoPage() {
    await this.page.goto('http://automationpractice.com/index.php');
    await expect(this.page).toHaveTitle('My Store');
  }

}