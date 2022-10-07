const { expect } = require('@playwright/test');
const { BasePage } = require('../pages/BasePage.js');

exports.Homepage = class Homepage extends BasePage{

  /**
   * @param {import('@playwright/test').Page} page
   */
  constructor(page) {
    super(page);
  }

}