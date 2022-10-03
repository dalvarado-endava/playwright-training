const { expect } = require('@playwright/test');
const { BasePage } = require('../pages/BasePage.js');

exports.AccountCreationPage = class AccountCreationPage extends BasePage{

  /**
   * @param {import('@playwright/test').Page} page
   */
  constructor(page) {
    super(page);
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

  async fillCustomerFirstName(firstname) {
    await this.customerFirstNameInput.fill(firstname);
  }

  async fillCustomerLastName(lastname) {
    await this.customerLastNameInput.fill(lastname);
  }

  async fillPassword(password) {
    await this.passwordInput.fill(password);
  }

  async fillFirstName(firstname) {
    await this.firstNameInput.fill(firstname);
  }

  async fillLastName(lastname) {
    await this.lastNameInput.fill(lastname);
  }

  async fillAddress(address) {
    await this.addressInput.fill(address);
  }

  async fillCity(city) {
    await this.cityInput.fill(city);
  }

  async fillState(state) {
    await this.stateDropdown.selectOption(state);
  }

  async fillPostCode(postcode) {
    await this.postCodeInput.fill(postcode);
  }

  async fillMobilePhone(phone) {
    await this.mobilePhoneInput.fill(phone);
  }

  async clickRegisterButton() {
    await this.registerButton.click();
  }

}