package com.epam.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class EpamContactUsPage {


    private final SelenideElement firstNameBox = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_first_name\"]");
    private final SelenideElement lastNameBox = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name\"]");
    private final SelenideElement emailBox = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email\"]");
    private final SelenideElement phoneBox = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone\"]");
    private final SelenideElement howDidYouHearBox = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor\"]/div[2]/div/div/div/div/div[8]/div[1]/div/span[1]/span[1]/span/span[1]");
    private final SelenideElement consentCheckBox = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor\"]/div[2]/div/div/div/div/div[9]/div/div[2]");
    private final SelenideElement submitButton = $x("//*[@id=\"_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor\"]/div[3]/div/div[2]/button");
    private final SelenideElement cookieAccept = $x("//*[@id=\"onetrust-accept-btn-handler\"]");

    public EpamContactUsPage(String url) {
        open(url);
    }

    public void checkformfieldsvalidation(){
//        firstNameBox.shouldBe(Condition.visible, Condition.enabled);
//        lastNameBox .shouldBe(Condition.visible, Condition.enabled);
//        emailBox.shouldBe(Condition.visible, Condition.enabled);
//        phoneBox.shouldBe(Condition.visible, Condition.enabled);
//        howDidYouHearBox.shouldBe(Condition.visible, Condition.enabled);
//        consentCheckBox.shouldBe(Condition.visible, Condition.enabled);
        cookieAccept.click();
        submitButton.click();
        firstNameBox.shouldHave(Condition.cssClass("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_first_name-error"));
        firstNameBox.shouldHave(Condition.cssClass("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name-error"));
        firstNameBox.shouldHave(Condition.cssClass("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email-error"));
        firstNameBox.shouldHave(Condition.cssClass("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone-error"));
        firstNameBox.shouldHave(Condition.cssClass("#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name-error"));
    }
}
