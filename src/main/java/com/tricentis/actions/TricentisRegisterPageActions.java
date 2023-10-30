package com.tricentis.actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.tricentis.pageobjects.TricentisRegisterPage;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static utils.RandomElementSelector.getRandom;
import static utils.RandomGenerator.getRandomGenerateUser;
import static utils.RandomGenerator.getRandomGeneratedEmail;

public class TricentisRegisterPageActions {

    private final List<String> registeredUser = new ArrayList<>();

    TricentisRegisterPage tricentisRegisterPage = new TricentisRegisterPage();

    public void registerRandomUser() {
        tricentisRegisterPage.getRegisterPageTransferButton().click();

        List<SelenideElement> genderSelect = new ArrayList<>();
        genderSelect.add(tricentisRegisterPage.getMaleGenderSelectRadioButton());
        genderSelect.add(tricentisRegisterPage.getFemaleGenderSelectRadioButton());

        SelenideElement selectedGender = getRandom(genderSelect);
        selectedGender.click();

        String randomEmail = getRandomGeneratedEmail();
        String randomPassword = getRandomGenerateUser();
        tricentisRegisterPage.getUserFirstNameBox().sendKeys(getRandomGenerateUser());
        tricentisRegisterPage.getUserLastNameBox().sendKeys(getRandomGenerateUser());
        tricentisRegisterPage.getUserEmailBox().sendKeys(randomEmail);
        tricentisRegisterPage.getUserPasswordBox().sendKeys(randomPassword);
        tricentisRegisterPage.getUserConfirmPasswordBox().sendKeys(randomPassword);

        tricentisRegisterPage.getRegisterUserButton().click();
        registeredUser.add(randomEmail);
        registeredUser.add(randomPassword);
    }

    public void verifyValidUserRegistration() {
        Assertions.assertThat(tricentisRegisterPage.getRegistrationConfirmationText()
                .text()).isEqualTo("Your registration completed");
        tricentisRegisterPage.getRegistrationContinueButton().click();
        tricentisRegisterPage.getUserRegisteredEmailNavigation().shouldBe(Condition.visible);
        System.out.println(tricentisRegisterPage.getUserRegisteredEmailNavigation().text());
        Assertions.assertThat(tricentisRegisterPage.getUserRegisteredEmailNavigation()
                .text()).contains(registeredUser.get(0));
    }

    public void userLogin() {
        tricentisRegisterPage.getLogOutNavigation().shouldHave(Condition.enabled, Condition.visible).click();
        tricentisRegisterPage.getRegisterPageTransferButton().shouldHave(Condition.visible);
        tricentisRegisterPage.getLogInNavigation().click();
        tricentisRegisterPage.getUserEmailBox().sendKeys(registeredUser.get(0));
        tricentisRegisterPage.getUserPasswordBox().sendKeys(registeredUser.get(1));
        tricentisRegisterPage.getLogInButton().click();
    }

    public void verifyValidUserLogin() {
        Assertions.assertThat(tricentisRegisterPage.getUserRegisteredEmailNavigation()
                .text()).contains(registeredUser.get(0));
    }
}
