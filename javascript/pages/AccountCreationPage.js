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
    this.password = '1234567890';
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

    await expect(this.customerFirstNameInput).toBeEditable();
    await this.customerFirstNameInput.fill(this.firstName);
    
    await expect(this.customerLastNameInput).toBeEditable();
    await this.customerLastNameInput.fill(this.lastName);
    
    await expect(this.passwordInput).toBeEditable();
    await this.passwordInput.fill(this.password);
    
    await expect(this.firstNameInput).toBeEditable();
    await this.firstNameInput.fill(this.firstName);
    
    await expect(this.lastNameInput).toBeEditable();
    await this.lastNameInput.fill(this.lastName);

    await expect(this.addressInput).toBeEditable();
    await this.addressInput.fill(this.address);
    
    await expect(this.cityInput).toBeEditable();
    await this.cityInput.fill(this.city);

    await expect(this.stateDropdown).toBeVisible();
    await this.stateDropdown.selectOption({value: '8'});

    await expect(this.postCodeInput).toBeEditable();
    await this.postCodeInput.fill(this.postCode);

    await expect(this.mobilePhoneInput).toBeEditable();
    await this.mobilePhoneInput.fill(this.mobilePhone);

  }

  async clickRegisterButton() {
    await expect(this.registerButton).toBeVisible();
    await this.registerButton.click();
  }

}