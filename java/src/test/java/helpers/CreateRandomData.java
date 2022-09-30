package helpers;

import com.github.javafaker.Faker;

import java.util.Locale;

public class CreateRandomData {
    private final Faker faker = new Faker(new Locale("en"));

    public String createRandomEmail() {
        return faker.bothify("????##@gmail.com");
    }

    public String createRandomFirstName() {
        return faker.name().firstName();
    }

    public String createRandomLastName() {
        return faker.name().lastName();
    }

    public String createRandomPassword() {
        return faker.regexify("[a-z1-9]{6}");
    }

    public String createRandomAddress() {
        return faker.address().streetName() + " " +
                faker.address().buildingNumber() + " " +
                faker.address().secondaryAddress();
    }

    public String createRandomZipcode() {
        return faker.number().digits(5);
    }

    public String createRandomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public String createRandomNickName() {
        return faker.name().username();
    }

    public int createRandomNumber(int maxNumber) {
        return faker.number().numberBetween(1, maxNumber);
    }
}
