const { expect } = require('@playwright/test');

exports.AccountCreationPage = class AccountCreationPage {

  /**
   * @param {import('@playwright/test').Page} page
   */
  constructor(page) {
    this.page = page;
    this.firstName = 'fakeFirstName';
    this.customerFirstNameInput = this.page.locator('#customer_firstname');
    this.lastName = 'fakeLastName';
    this.customerLastNameInput = this.page.locator('#customer_lastname');
    this.passwordInput = this.page.locator('#passwd');
    this.firstNameInput = this.page.locator('#firstname');
    this.lastNameInput = this.page.locator('#lastname');
    this.address = 'Fake Street # 12-34';
    this.addressInput = this.page.locator('#address1');
    this.city = 'fakeCity';
    this.cityInput = this.page.locator('#city');
    this.stateDropdown = this.page.locator('#id_state');
    this.postCode = '11001';
    this.postCodeInput = this.page.locator('#postcode');
    this.mobilePhone = '1234567897';
    this.mobilePhoneInput = this.page.locator('#phone_mobile');
    this.registerButton = this.page.locator('#submitAccount');
  }

  async fillRequiredInputs() {

    await expect(this.page).toHaveTitle('Login - My Store');
    await this.customerFirstNameInput.fill(this.firstName);
    await this.customerLastNameInput.fill(this.lastName);
    await this.passwordInput.fill(process.env.PASSWORD);
    await this.firstNameInput.fill(this.firstName);
    await this.lastNameInput.fill(this.lastName);
    await this.addressInput.fill(this.address);
    await this.cityInput.fill(this.city);
    await this.stateDropdown.selectOption({value: '8'});
    await this.postCodeInput.fill(this.postCode);
    await this.mobilePhoneInput.fill(this.mobilePhone);
  }

  async clickRegisterButton() {
    await expect(this.registerButton).toBeVisible();
    await this.registerButton.click();
  }

}