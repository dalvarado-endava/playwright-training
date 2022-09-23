package test;

import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Payments extends BaseTest {

    @Test
    public void checkoutTest(){
        assertThat(homePage.blockPopularSellers).isVisible();
        homePage.selectRandomPopularItem();
        assertThat(homePage.randomPopularItem).isVisible();
        homePage.clickOnRandomPopularItem();
        assertThat(itemPage.addButton).isVisible();
        assertThat(itemPage.buyBlock).isVisible();
        itemPage.clickAddButton();
        assertThat(addPopup.cart).isVisible();
        assertThat(addPopup.proceedCheckoutButton).isVisible();
        addPopup.clickOnProceedCheckoutButton();
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
        address.cartNavigation.clickOnProceedCheckoutButton();
        assertThat(payment.payByBank).isVisible();
        payment.clickOnPayByBank();
        assertThat(payment.confirmMyOrderButton).isVisible();
        payment.clickOnConfirmMyOrderButton();
        assertThat(payment.successMessage).containsText("Your order on My Store is complete");
    }

    @Test
    public void addItemsToCartAndDeleteIt() {
        assertThat(homePage.blockPopularSellers).isVisible();
        homePage.selectRandomPopularItem();
        assertThat(homePage.randomPopularItem).isVisible();
        homePage.passMouseOverRandomItem();
        assertThat(homePage.getAddButton()).isVisible();
        homePage.clickOnAddButton();
        assertThat(addPopup.continueShopping).isVisible();
        addPopup.clickOnContinueShoppingButton();
        homePage.selectRandomPopularItem();
        assertThat(homePage.randomPopularItem).isVisible();
        homePage.passMouseOverRandomItem();
        homePage.clickOnAddButton();
        addPopup.clickOnProceedCheckoutButton();
        assertThat(submit.cartNavigation.summary).isVisible();
        assertThat(submit.cartSummary.productTable).hasCount(2);
        submit.cartSummary.clickOnFirstTrashIcon();
        assertThat(submit.cartNavigation.proceedCheckoutButton).isVisible();
        assertThat(submit.cartSummary.productTable).hasCount(1);
        submit.cartNavigation.clickOnProceedCheckoutButton();
        loginPage.fillSingInMail(userEmail);
        loginPage.fillSingInPassword(userPassword);
        loginPage.clickOnSingInButton();
        assertThat(address.cartNavigation.proceedCheckoutButton2).isVisible();
        address.cartNavigation.clickOnProceedCheckoutButton2();
        assertThat(shipping.checker).isVisible();
        shipping.checkAgreedTerms();
        assertThat(address.cartNavigation.proceedCheckoutButton).isVisible();
        address.cartNavigation.clickOnProceedCheckoutButton();
        assertThat(payment.cartSummary.productTable).hasCount(1);
        assertThat(payment.payByBank).isVisible();
        payment.clickOnPayByBank();
        assertThat(payment.confirmMyOrderButton).isVisible();
        payment.clickOnConfirmMyOrderButton();
        assertThat(payment.successMessage).containsText("Your order on My Store is complete");
    }

    @Test
    public void cartTest(){
        assertThat(homePage.searchBar).isVisible();
        homePage.fillTheSearchBar();
        homePage.clickTheSearchButton();
        assertThat(searchPage.getSearch()).isVisible();
        searchPage.clickOnTheFirstItem();
        assertThat(itemPopup.getAddToCartButton()).isVisible();
        itemPopup.clickAddToCart();
        assertThat(addPopup.cart).isVisible();
        assertThat(addPopup.proceedCheckoutButton).isVisible();
        addPopup.clickOnProceedCheckoutButton();
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
