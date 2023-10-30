package com.tricentis.pageobjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
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

}

