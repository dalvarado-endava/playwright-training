package test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;


public class Payments extends BaseTest {

    @Test
    @Feature("Payments")
    @Description("As user I want to select and item from the popular block and follow the complete flow for payments")
    public void purchaseOnePopularElement() {
        homePage.assertThatBlockPopularSellersIsVisible();
        homePage.selectRandomPopularItem();
        homePage.assertThatRandomPopularItemIsVisible();
        homePage.clickOnRandomPopularItem();
        itemPage.assertThatAddButtonIsVisible();
        itemPage.assertThatBuyBlockIsVisible();
        itemPage.clickAddButton();
        addPopup.assertThatCartIsVisible();
        addPopup.assertThatProceedCheckoutButtonIsVisible();
        addPopup.clickOnProceedCheckoutButton();
        submit.cartNavigation.assertThatSummaryIsVisible();
        submit.cartNavigation.assertThatProceedCheckoutButtonIsVisible();
        submit.cartNavigation.clickOnProceedCheckoutButton();
        loginPage.fillSingInMail(userEmail);
        loginPage.fillSingInPassword(userPassword);
        loginPage.clickOnSingInButton();
        address.cartNavigation.assertThatProceedCheckoutButton2IsVisible();
        address.cartNavigation.clickOnProceedCheckoutButton2();
        shipping.assertThatCheckerAgreedTermsIsVisible();
        shipping.checkAgreedTerms();
        address.cartNavigation.assertThatProceedCheckoutButtonIsVisible();
        address.cartNavigation.clickOnProceedCheckoutButton();
        payment.assertThatPayBankIsVisible();
        payment.clickOnPayByBank();
        payment.assertThatConfirmMyOrderButtonIsVisible();
        payment.clickOnConfirmMyOrderButton();
        payment.assertThatSuccessMessageContainsText("Your order on My Store is complete");
    }

    @Test
    @Feature("Payments")
    @Description("As user I want to select two elements from the popular block and then in the summary I wan to to delete one and follow the complete flow for payments")
    public void addItemsToCartAndDeleteIt() {
        homePage.assertThatBlockPopularSellersIsVisible();
        homePage.selectRandomPopularItem();
        homePage.assertThatRandomPopularItemIsVisible();
        homePage.passMouseOverRandomItem();
        homePage.assertThatAddButtonIsVisible();
        homePage.clickOnAddButton();
        addPopup.assertThatProceedCheckoutButtonIsVisible();
        addPopup.clickOnContinueShoppingButton();
        homePage.selectRandomPopularItem();
        homePage.assertThatRandomPopularItemIsVisible();
        homePage.passMouseOverRandomItem();
        homePage.assertThatAddButtonIsVisible();
        homePage.clickOnAddButton();
        addPopup.clickOnProceedCheckoutButton();
        submit.cartNavigation.assertThatSummaryIsVisible();
        submit.cartSummary.assertThatProductTableContainsNumberOfProducts(2);
        submit.cartSummary.clickOnFirstTrashIcon();
        submit.cartNavigation.assertThatProceedCheckoutButtonIsVisible();
        submit.cartSummary.assertThatProductTableContainsNumberOfProducts(1);
        submit.cartNavigation.clickOnProceedCheckoutButton();
        loginPage.fillSingInMail(userEmail);
        loginPage.fillSingInPassword(userPassword);
        loginPage.clickOnSingInButton();
        address.cartNavigation.assertThatProceedCheckoutButton2IsVisible();
        address.cartNavigation.clickOnProceedCheckoutButton2();
        shipping.assertThatCheckerAgreedTermsIsVisible();
        shipping.checkAgreedTerms();
        address.cartNavigation.assertThatProceedCheckoutButtonIsVisible();
        address.cartNavigation.clickOnProceedCheckoutButton();
        payment.cartSummary.assertThatProductTableContainsNumberOfProducts(1);
        payment.assertThatPayBankIsVisible();
        payment.clickOnPayByBank();
        payment.assertThatConfirmMyOrderButtonIsVisible();
        payment.clickOnConfirmMyOrderButton();
        payment.assertThatSuccessMessageContainsText("Your order on My Store is complete");
    }

    @Test
    @Feature("Payments")
    @Description("As user I want to search for an item in the search bar, and the I want to select the first and follow the complete flow for payments")
    public void cartTest() {
        homePage.menuComponent.assertSearchBarIsVisible();
        homePage.menuComponent.fillTheSearchBar("Blouse");
        homePage.menuComponent.clickTheSearchButton();
        searchPage.assertSearchResultsAreVisible();
        searchPage.passMouseOverTheFirstItem();
        searchPage.assertThatAddButtonIsVisible();
        searchPage.clickOnAddButton();
        itemPopup.clickAddToCart();
        addPopup.assertThatCartIsVisible();
        addPopup.assertThatProceedCheckoutButtonIsVisible();
        addPopup.clickOnProceedCheckoutButton();
        submit.cartNavigation.assertThatSummaryIsVisible();
        submit.cartNavigation.assertThatProceedCheckoutButtonIsVisible();
        submit.cartNavigation.clickOnProceedCheckoutButton();
        loginPage.fillSingInMail(userEmail);
        loginPage.fillSingInPassword(userPassword);
        loginPage.clickOnSingInButton();
        address.cartNavigation.assertThatProceedCheckoutButton2IsVisible();
        address.cartNavigation.clickOnProceedCheckoutButton2();
        shipping.assertThatCheckerAgreedTermsIsVisible();
        shipping.checkAgreedTerms();
        address.cartNavigation.assertThatProceedCheckoutButtonIsVisible();
        address.cartNavigation.proceedCheckoutButton.click();
        payment.assertThatPayBankIsVisible();
        payment.clickOnPayByBank();
        payment.assertThatConfirmMyOrderButtonIsVisible();
        payment.clickOnConfirmMyOrderButton();
        payment.assertThatSuccessMessageContainsText("Your order on My Store is complete");
    }
}
