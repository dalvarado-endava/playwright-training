package test;

import org.testng.annotations.Test;
import resources.InitialSetup;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Examples extends InitialSetup {

    @Test
    public void clickOnBestSellerButton(){
        homePage.clickOnBestSellers();
        assertThat(homePage.getFirstBestSellerOnList()).containsText("Printed Chiffon Dress");
        System.out.println("Seller in thread "+ Thread.currentThread().getId());
    }

    @Test
    public void clickOnSecondAnnounce(){
        homePage.clickSecondAnnounce();
        System.out.println("Announce in thread "+ Thread.currentThread().getId());
    }

}