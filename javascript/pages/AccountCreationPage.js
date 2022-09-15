const { expect } = require('@playwright/test');
const data = require('../data/data.json');
const randomize = require('../helpers/randomize');

exports.AccountCreationPage = class AccountCreationPage {

  /**
   * @param {import('@playwright/test').Page} page
   */
  constructor(page) {
    this.page = page;
    this.customerFirstNameInput = this.page.locator('#customer_firstname');
    this.customerLastNameInput = this.page.locator('#customer_lastname');
    this.passwordInput = this.page.locator('#passwd');
    this.firstNameInput = this.page.locator('#firstname');
    this.lastNameInput = this.page.locator('#lastname');
    this.addressInput = this.page.locator('#address1');
    this.cityInput = this.page.locator('#city');
    this.stateDropdown = this.page.locator('#id_state');
    this.postCodeInput = this.page.locator('#postcode');
    this.mobilePhoneInput = this.page.locator('#phone_mobile');
    this.registerButton = this.page.locator('#submitAccount');
  }

  async fillRequiredInputs() {

    await expect(this.page).toHaveTitle('Login - My Store');  
    await this.customerFirstNameInput.fill(data.user.firstname);
    await this.customerLastNameInput.fill(data.user.lastname);
    await this.passwordInput.fill(process.env.PASSWORD);
    await this.firstNameInput.fill(data.user.firstname);
    await this.lastNameInput.fill(data.user.lastname);
    await this.addressInput.fill(data.user.address);
    await this.cityInput.fill(data.user.city);
    await this.stateDropdown.selectOption(randomize.state());
    await this.postCodeInput.fill(data.user.postcode);
    await this.mobilePhoneInput.fill(data.user.phone);
  }

  async clickRegisterButton() {
    await this.registerButton.click();
  }

}