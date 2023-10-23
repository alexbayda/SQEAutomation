package pageobjects;

import com.codeborne.selenide.*;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static utils.RandomElementSelector.getRandom;
import static utils.RandomGenerator.getRandomGeneratedEmail;
import static utils.RandomGenerator.getRandomGenerateUser;

public class TricentisRegisterPage {

    private final SelenideElement registerPageTransferButton = $x("//a[@class='ico-register']");
    private final SelenideElement registerUserButton = $x("//input[@id='register-button']");
    private final SelenideElement maleGenderSelectRadioButton = $x("//input[@id='gender-male']");
    private final SelenideElement femaleGenderSelectRadioButton = $x("//input[@id='gender-female']");
    private final SelenideElement userFirstNameBox = $x("//input[@id='FirstName']");
    private final SelenideElement userLastNameBox = $x("//input[@id='LastName']");
    private final SelenideElement userEmailBox = $x("//input[@id='Email']");
    private final SelenideElement userPasswordBox = $x("//input[@id='Password']");
    private final SelenideElement userConfirmPasswordBox = $x("//input[@id='ConfirmPassword']");
    private final SelenideElement registrationConfirmationText = $x("//div[@class='result']");
    private final SelenideElement registrationContinueButton = $x("//input[@value='Continue']");
    private final SelenideElement userRegisteredEmailNavigation = $("div[class='header-links'] a[class='account']");
    private final SelenideElement logOutNavigation = $x("//a[@class='ico-logout']");
    private final SelenideElement logInNavigation = $x("//a[@class='ico-login']");
    private final SelenideElement logInButton = $x("//input[@value='Log in']");

    public void verifyValidUserRegistration() {
        registerPageTransferButton.click();

        List<SelenideElement> genderSelect = new ArrayList<>();
        genderSelect.add(maleGenderSelectRadioButton);
        genderSelect.add(femaleGenderSelectRadioButton);

        SelenideElement selectedGender = getRandom(genderSelect);
        selectedGender.click();

        String randomEmail = getRandomGeneratedEmail();
        String randomPassword = getRandomGenerateUser();
        userFirstNameBox.sendKeys(getRandomGenerateUser());
        userLastNameBox.sendKeys(getRandomGenerateUser());
        userEmailBox.sendKeys(randomEmail);
        userPasswordBox.sendKeys(randomPassword);
        userConfirmPasswordBox.sendKeys(randomPassword);

        registerUserButton.click();

        Assertions.assertThat(registrationConfirmationText.text()).isEqualTo("Your registration completed");
        registrationContinueButton.click();
        Assertions.assertThat(userRegisteredEmailNavigation.text()).isEqualTo(randomEmail);
    }

    public void verifyValidUserLogin() {
        registerPageTransferButton.click();

        List<SelenideElement> genderSelect = new ArrayList<>();
        genderSelect.add(maleGenderSelectRadioButton);
        genderSelect.add(femaleGenderSelectRadioButton);

        SelenideElement selectedGender = getRandom(genderSelect);
        selectedGender.click();

        String randomEmail = getRandomGeneratedEmail();
        String randomPassword = getRandomGenerateUser();
        userFirstNameBox.sendKeys(getRandomGenerateUser());
        userLastNameBox.sendKeys(getRandomGenerateUser());
        userEmailBox.sendKeys(randomEmail);
        userPasswordBox.sendKeys(randomPassword);
        userConfirmPasswordBox.sendKeys(randomPassword);
        registerUserButton.click();

        Assertions.assertThat(registrationConfirmationText.text()).isEqualTo("Your registration completed");

        logOutNavigation.shouldHave(Condition.enabled, Condition.visible).click();
        registerPageTransferButton.shouldHave(Condition.visible);
        logInNavigation.click();
        userEmailBox.sendKeys(randomEmail);
        userPasswordBox.sendKeys(randomPassword);
        logInButton.click();

        Assertions.assertThat(userRegisteredEmailNavigation.text()).isEqualTo(randomEmail);
    }
}

