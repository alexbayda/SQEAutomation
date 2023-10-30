package com.epam.pageobjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class EpamContactUsPage {


    private final SelenideElement firstNameBox = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_first_name");
    private final SelenideElement lastNameBox = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name");
    private final SelenideElement emailBox = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email");
    private final SelenideElement phoneBox = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone");

    private final SelenideElement howDidYouHearBox = $x("(//span[@role='textbox'])[6]");
    private final SelenideElement consentCheckBox = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor > div.layout-box > div > div > div > div > div:nth-child(9) > div > div.checkbox__holder");
    private final SelenideElement submitButton = $x("//button[@type='submit']");
    private final SelenideElement cookieAccept = $x("//button[@id='onetrust-accept-btn-handler']");

    private final SelenideElement firstNameTextLabel = $("label[for='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_first_name']");
    private final SelenideElement lastNameTextLabel = $("label[for='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name']");
    private final SelenideElement emailTextLabel = $("label[for='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email']");
    private final SelenideElement phoneTextLabel = $("label[for='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone']");
    private final SelenideElement getHowDidYouHearTextLabel = $("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_comment_how_hear_about-label");

    private final SelenideElement firstNameError = $x("//*[@id='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_first_name-error']");
    private final SelenideElement lastNameError = $x("//*[@id='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name-error']");
    private final SelenideElement emailError = $x("//*[@id='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email-error']");
    private final SelenideElement phoneError = $x("//*[@id='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone-error']");
    private final SelenideElement howDidYouHearBoxError = $x("//div[contains(@class,'dropdown-list__input form-component__input')]//span[@id='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_comment_how_hear_about-error']");

}
