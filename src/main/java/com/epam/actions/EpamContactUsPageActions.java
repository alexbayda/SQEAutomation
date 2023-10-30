package com.epam.actions;

import com.codeborne.selenide.Condition;
import com.epam.pageobjects.EpamContactUsPage;

import static assertions.EpamPageAssertions.assertCheckBoxTurnRed;
import static assertions.EpamPageAssertions.assertRequiredFieldTurnRedAndErrorMessageIsVisible;

public class EpamContactUsPageActions {

    EpamContactUsPage epamContactUsPage = new EpamContactUsPage();

    public void checkFormFieldsValidation() {
        epamContactUsPage.getCookieAccept().click();
        epamContactUsPage.getFirstNameBox().shouldBe(Condition.visible, Condition.enabled);
        epamContactUsPage.getLastNameBox().shouldBe(Condition.visible, Condition.enabled);
        epamContactUsPage.getEmailBox().shouldBe(Condition.visible, Condition.enabled);
        epamContactUsPage.getPhoneBox().shouldBe(Condition.visible, Condition.enabled);
        epamContactUsPage.getHowDidYouHearBox().shouldBe(Condition.visible);
        epamContactUsPage.getConsentCheckBox().shouldBe(Condition.visible, Condition.enabled);

        epamContactUsPage.getSubmitButton().click();
        assertCheckBoxTurnRed(epamContactUsPage.getConsentCheckBox());
        assertRequiredFieldTurnRedAndErrorMessageIsVisible(epamContactUsPage.getFirstNameBox()
                , epamContactUsPage.getFirstNameError(), epamContactUsPage.getFirstNameTextLabel());
        assertRequiredFieldTurnRedAndErrorMessageIsVisible(epamContactUsPage.getLastNameBox()
                , epamContactUsPage.getLastNameError(), epamContactUsPage.getLastNameTextLabel());
        assertRequiredFieldTurnRedAndErrorMessageIsVisible(epamContactUsPage.getEmailBox()
                , epamContactUsPage.getEmailError(), epamContactUsPage.getEmailTextLabel());
        assertRequiredFieldTurnRedAndErrorMessageIsVisible(epamContactUsPage.getPhoneBox()
                , epamContactUsPage.getPhoneError(), epamContactUsPage.getPhoneTextLabel());
        assertRequiredFieldTurnRedAndErrorMessageIsVisible(epamContactUsPage.getHowDidYouHearBox()
                , epamContactUsPage.getHowDidYouHearBoxError(), epamContactUsPage.getGetHowDidYouHearTextLabel());
    }
}
