package com.epam.ui.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.epam.ui.assertions.EpamPageAssertions.assertCheckBoxTurnRed;
import static com.epam.ui.assertions.EpamPageAssertions.assertRequiredFieldTurnRedAndErrorMessageIsVisible;

public class EpamContactUsPage {


    private final SelenideElement firstNameBox = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_first_name");
    private final SelenideElement lastNameBox = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name");
    private final SelenideElement emailBox = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email");
    private final SelenideElement phoneBox = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone");
    private final SelenideElement howDidYouHearBox = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor\"]/div[2]/div/div/div/div/div[8]/div[1]/div/span[1]/span[1]/span/span[1]");
    private final SelenideElement consentCheckBox = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor > div.layout-box > div > div > div > div > div:nth-child(9) > div > div.checkbox__holder");
    private final SelenideElement submitButton = $x("//button[@type='submit']");
    private final SelenideElement cookieAccept = $x("//button[@id=\"onetrust-accept-btn-handler\"]");

    private final SelenideElement firstNameTextLabel = $("label[for='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_first_name']");
    private final SelenideElement lastNameTextLabel = $("label[for='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name']");
    private final SelenideElement emailTextLabel = $("label[for='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email']");
    private final SelenideElement phoneTextLabel = $("label[for='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone']");
    private final SelenideElement getHowDidYouHearTextLabel = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_comment_how_hear_about-label");

    private final SelenideElement firstNameError = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_first_name-error\"]");
    private final SelenideElement lastNameError = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name-error\"]");
    private final SelenideElement emailError = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email-error\"]");
    private final SelenideElement phoneError = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone-error\"]");
    private final SelenideElement howDidYouHearBoxError = $x("//div[contains(@class,'dropdown-list__input form-component__input')]//span[@id='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_comment_how_hear_about-error']");

    public EpamContactUsPage(String url) {
        open(url);
    }

    public void checkFormFieldsValidation() {
        cookieAccept.click();
        firstNameBox.shouldBe(Condition.visible, Condition.enabled);
        lastNameBox.shouldBe(Condition.visible, Condition.enabled);
        emailBox.shouldBe(Condition.visible, Condition.enabled);
        phoneBox.shouldBe(Condition.visible, Condition.enabled);
        howDidYouHearBox.shouldBe(Condition.visible);
        consentCheckBox.shouldBe(Condition.visible, Condition.enabled);

        submitButton.click();

        assertCheckBoxTurnRed(consentCheckBox);
        assertRequiredFieldTurnRedAndErrorMessageIsVisible(firstNameBox, firstNameError, firstNameTextLabel);
        assertRequiredFieldTurnRedAndErrorMessageIsVisible(lastNameBox, lastNameError, lastNameTextLabel);
        assertRequiredFieldTurnRedAndErrorMessageIsVisible(lastNameBox, lastNameError, lastNameTextLabel);
        assertRequiredFieldTurnRedAndErrorMessageIsVisible(emailBox, emailError, emailTextLabel);
        assertRequiredFieldTurnRedAndErrorMessageIsVisible(phoneBox, phoneError, phoneTextLabel);
        assertRequiredFieldTurnRedAndErrorMessageIsVisible(howDidYouHearBox, howDidYouHearBoxError, getHowDidYouHearTextLabel);
    }
}
