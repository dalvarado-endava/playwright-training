package test;

import org.testng.annotations.Test;
import resources.InitialSetup;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Payments extends InitialSetup {

    @Test
    public void checkoutTest(){
        assertThat(homePage.blockPopularSellers).isVisible();
        homePage.selectRandomPopularItem();
        homePage.selectRandomPopularItem();
        assertThat(homePage.randomPopularItem).isVisible();
        homePage.clickOnRandomPopularItem();
        assertThat(itemPage.addButton).isVisible();
        assertThat(itemPage.buyBlock).isVisible();
        itemPage.clickAddButton();
        assertThat(addPopup.card).isVisible();
        assertThat(addPopup.proceedCheckoutButton).isVisible();
        addPopup.clickProceedCheckoutButton();
        assertThat(submit.cartNavigation.summary).isVisible();
        assertThat(submit.cartNavigation.proceedCheckoutButton).isVisible();
        submit.cartNavigation.clickOnProceedCheckoutButton();
        loginPage.fillSingInMail(userEmail);
        loginPage.fillSingInPassword(userPassword);
        loginPage.clickOnSingInButton();
        assertThat(address.cartNavigation.proceedCheckoutButton2).isVisible();
        address.cartNavigation.clickOnProceedCheckoutButton2();
        assertThat(shipping.checker).isVisible();
        shipping.checkAgreedTerms();
        assertThat(address.cartNavigation.proceedCheckoutButton).isVisible();
        address.cartNavigation.proceedCheckoutButton.click();
        assertThat(payment.payByBank).isVisible();
        payment.clickOnPayByBank();
        assertThat(payment.confirmMyOrderButton).isVisible();
        payment.clickOnConfirmMyOrderButton();
        assertThat(payment.successMessage).containsText("Your order on My Store is complete");
    }
}
