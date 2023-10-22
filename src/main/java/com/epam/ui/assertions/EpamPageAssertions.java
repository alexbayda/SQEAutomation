package com.epam.ui.assertions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;

import static com.codeborne.selenide.Selenide.actions;

public class EpamPageAssertions {

    public static void assertCheckBoxTurnRed(SelenideElement consentCheckBox){
        String redBorderColor = "rgb(255, 77, 64)";
        Assertions.assertThat(consentCheckBox.getCssValue("border-color")).isEqualTo(redBorderColor);
    }

    public static void assertRequiredFieldTurnRedAndErrorMessageIsVisible(SelenideElement inputBox, SelenideElement errorBox,
                                                                          SelenideElement inputBoxLabel){
        String redRgbaColor = "rgba(255, 77, 64, 1)";

        actions().moveToElement(inputBox).perform();
        errorBox.shouldBe(Condition.visible);
        Assertions.assertThat(errorBox.text()).contains("This is a required field");
        Assertions.assertThat(inputBoxLabel.getCssValue("color")).isEqualTo(redRgbaColor);
    }
}
