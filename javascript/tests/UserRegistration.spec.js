const { test } = require('@playwright/test');
const { AccountCreationPage } = require('../pages/AccountCreationPage.js');
const { Homepage } = require('../pages/Homepage.js');
const { MyAccountPage } = require('../pages/MyAccountPage.js');


test('Successful user registration', async ( {page} )=>{
    
    const homepage = new Homepage(page);
    await homepage.gotoPage();
    await homepage.clickSignInButton();
    await homepage.typeEmail();
    await homepage.clickCreateAnAccountButton();    
    
    const accountCreationPage = new AccountCreationPage(page);
    await accountCreationPage.fillRequiredInputs();
    await accountCreationPage.clickRegisterButton();
    
    const myAccountPage = new MyAccountPage(page);
    await myAccountPage.validateMyAccountTitle();
    await myAccountPage.validateUserName(accountCreationPage);
    
});