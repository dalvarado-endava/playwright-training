package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import helpers.CreateRandomData;
import pages.components.MenuComponent;

public class CreateAnAccountPage extends BasePage{
    private Locator firstName;
    private Locator lastName;
    private Locator email;
    private Locator password;
    private Locator address;
    private Locator city;
    private Locator stateDropDownMenu;
    private Locator state;
    private Locator zip;
    private Locator mobilePhone;
    private Locator registerButton;

    public MenuComponent menuComponent;

    public CreateAnAccountPage (Page page){
        super(page);
        menuComponent = new MenuComponent(page);
        firstName = page.locator("#customer_firstname");
        lastName = page.locator("#customer_lastname");
        email = page.locator("#email");
        password = page.locator("#passwd");
        address = page.locator("#address1");
        city = page.locator("#city");
        stateDropDownMenu = page.locator("#id_state");
        state = page.locator("#");
        zip = page.locator("#postcode");
        mobilePhone = page.locator("#phone_mobile");
        registerButton = page.locator("#submitAccount");
    }

    public void fillFirstName(){
        String randomFirstName = new CreateRandomData().createRandomFirstName();
        firstName.fill(randomFirstName);
    }

    public void fillLastName(){
        String randomLastName = new CreateRandomData().createRandomLastName();
        lastName.fill(randomLastName);
    }

    public void fillEmail(){
        String randomEmail = new CreateRandomData().createRandomEmail();
        email.fill(randomEmail);
    }

    public void fillPassword(){
        String randomPassword = new CreateRandomData().createRandomPassword();
        password.fill(randomPassword);
    }

    public void fillAddress() {
        String randomAddress = new CreateRandomData().createRandomAddress();
        address.fill(randomAddress);
    }

    public void fillCity(){
        String randomCity = new CreateRandomData().createRandomNickName();
        city.fill(randomCity);
    }

    public void selectState(){
        stateDropDownMenu.click();
        state.click();
    }

    public void fillZip(){
        String randomZip = new CreateRandomData().createRandomZipcode();
        zip.fill(randomZip);
    }

    public void fillMobilePhone(){
        String randomPhone = new CreateRandomData().createRandomPhoneNumber();
        mobilePhone.fill(randomPhone);
    }

    public void clickInRegisterButton(){
        registerButton.click();
    }
}
