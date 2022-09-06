package test;

import org.testng.annotations.Test;
import resources.InitialSetup;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Examples2 extends InitialSetup {

    @Test
    public void clickOnBestSingButton(){
        homePage.menuComponent.clickOnSingInButton();
        assertThat(loginPage.getCreateAccountMail()).isEditable();
        loginPage.fillCreateAccountEmail();
        loginPage.clickOnCreateAccountButton();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sing button in thread "+ Thread.currentThread().getId());
    }

    @Test
    public void clickOnSecondAnnounce2(){
        homePage.clickSecondAnnounce();
        System.out.println("Announce 2 in thread "+ Thread.currentThread().getId());
    }

}