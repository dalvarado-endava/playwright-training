package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import helpers.CreateRandomData;
import pages.components.MenuComponent;

public class CreateAnAccountPage extends BasePage {
    private final Locator firstName;
    private final Locator customerFirstName;
    private final Locator lastName;
    private final Locator customerLastName;
    private final Locator email;
    private final Locator password;
    private final Locator address;
    private final Locator city;
    private final Locator stateDropDownMenu;
    private final Locator zip;
    private final Locator mobilePhone;
    private final Locator registerButton;
    private final Logger log = LoggerFactory.getLogger(CreateAnAccountPage.class);

    public MenuComponent menuComponent;

    public CreateAnAccountPage(Page page) {
        super(page);
        menuComponent = new MenuComponent(page);
        customerFirstName = page.locator("#customer_firstname");
        firstName = page.locator("#firstname");
        customerLastName = page.locator("#customer_lastname");
        lastName = page.locator("#lastname");
        email = page.locator("#email");
        password = page.locator("#passwd");
        address = page.locator("#address1");
        city = page.locator("#city");
        stateDropDownMenu = page.locator("#id_state");
        zip = page.locator("#postcode");
        mobilePhone = page.locator("#phone_mobile");
        registerButton = page.locator("#submitAccount");
    }

    @Step("Fill first name")
    public void fillFirstName() {
        log.info("Filling the first name");
        String randomFirstName = new CreateRandomData().createRandomFirstName();
        customerFirstName.fill(randomFirstName);
        firstName.fill(randomFirstName);
        log.info("The first name was filled with: {}", randomFirstName);
    }


    @Step("Fill last name")
    public void fillLastName() {
        log.info("Filling the last name");
        String randomLastName = new CreateRandomData().createRandomLastName();
        customerLastName.fill(randomLastName);
        lastName.fill(randomLastName);
        log.info("The last name was filled with: {}", randomLastName);
    }

    @Step("Fill email")
    public void fillEmail() {
        log.info("Filling the email");
        String randomEmail = new CreateRandomData().createRandomEmail();
        email.fill(randomEmail);
        log.info("The email was filled with: {}", randomEmail);
    }

    @Step("Fill password")
    public void fillPassword() {
        log.info("Filling the password");
        String randomPassword = new CreateRandomData().createRandomPassword();
        password.fill(randomPassword);
        log.info("The password was filled with: {}", randomPassword);
    }

    @Step("Fill address")
    public void fillAddress() {
        log.info("Filling the Address");
        String randomAddress = new CreateRandomData().createRandomAddress();
        address.fill(randomAddress);
        log.info("The Address was filled with: {}", randomAddress);
    }

    @Step("Fill city")
    public void fillCity() {
        log.info("Filling the city");
        String randomCity = new CreateRandomData().createRandomNickName();
        city.fill(randomCity);
        log.info("The city was filled with: {}", randomCity);
    }

    @Step("Select State")
    public void selectState() {
        log.info("Selecting state");
        stateDropDownMenu.click();
        log.info("PASO PASO PASO PASO");
        stateDropDownMenu.selectOption("1");
        log.info("The state was selected");
    }

    @Step("Fill zip code")
    public void fillZip() {
        log.info("Filling the Zip code");
        String randomZip = new CreateRandomData().createRandomZipcode();
        zip.fill(randomZip);
        log.info("The Zip code was filled with: {}", randomZip);
    }

    @Step("Fill mobile phone")
    public void fillMobilePhone() {
        log.info("Filling the mobile phone");
        String randomPhone = new CreateRandomData().createRandomPhoneNumber();
        mobilePhone.fill(randomPhone);
        log.info("The mobile phone was filled with: {}", randomPhone);
    }

    @Step("clicking register button")
    public void clickInRegisterButton() {
        registerButton.click();
        log.info("clicking register button");
    }

    @Step("Assert that first name is editable")
    public void assertThatFirstNameIsEditable() {
        assertIfLocatorIsEditable(firstName);
    }

    @Step("Assert that last name is editable")
    public void assertThatLastNameIsEditable() {
        assertIfLocatorIsEditable(lastName);
    }

    @Step("Assert that email is editable")
    public void assertThatEmailIsEditable() {
        assertIfLocatorIsEditable(email);
    }

    @Step("Assert that password is editable")
    public void assertThatPasswordIsEditable() {
        assertIfLocatorIsEditable(password);
    }

    @Step("Assert that address is editable")
    public void assertThatAddressIsEditable() {
        assertIfLocatorIsEditable(address);
    }

    @Step("Assert that city is editable")
    public void assertThatCityIsEditable() {
        assertIfLocatorIsEditable(city);
    }

    @Step("Assert that state drop down is visible")
    public void assertThatStateDropDownIsVisible() {
        assertIfLocatorIsEditable(stateDropDownMenu);
    }

    @Step("Assert that zip code is editable")
    public void assertThatZipCodeIsEditable() {
        assertIfLocatorIsEditable(zip);
    }

    @Step("Assert that mobile phone is editable")
    public void assertThatMobilePhoneIsEditable() {
        assertIfLocatorIsEditable(mobilePhone);
    }
}
