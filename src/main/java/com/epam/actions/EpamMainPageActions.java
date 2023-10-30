package com.epam.actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.epam.pageobjects.EpamMainPage;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.title;
import static utils.CustomWaiter.waitForElementWithCondition;

@Slf4j
public class EpamMainPageActions {

    EpamMainPage epamMainPage = new EpamMainPage();

    public void checkTitleIsCorrect(String title) {
        String expectedTitle = title();
        Assertions.assertThat(expectedTitle).isEqualTo(title);
    }

    public boolean isLightMode() {
        return epamMainPage.getThemeLightMode().exists();
    }

    public boolean isDarkMode() {
        return epamMainPage.getThemeDarkMode().exists();
    }

    public void checkLightDarkModeAbility() {
        boolean isInitiallyLightMode = isLightMode();
        boolean isInitiallyDarkMode = isDarkMode();
        if (isInitiallyDarkMode) {
            epamMainPage.getThemeSwitcherToggle().click();
            Assertions.assertThat(isLightMode()).isTrue();
        } else if (isInitiallyLightMode) {
            epamMainPage.getThemeSwitcherToggle().click();
            Assertions.assertThat(isDarkMode()).isTrue();
        }
    }

    private String getCurrentLanguageText() {
        return epamMainPage.getLanguageSelectorButton().getText();
    }

    public void checkToChangeLanguage(String languageOption) {
        epamMainPage.getLanguageSelectorButton().click();
        epamMainPage.getUkrainianLanguageChanger().click();
        Assertions.assertThat(getCurrentLanguageText()).contains(languageOption);
    }

    public void checkPoliciesListHasCorrectItems(List<String> policyItems) {
        ElementsCollection policiesList = epamMainPage.getPoliciesList();
        Assertions.assertThat(policiesList).isNotEmpty();
        String allPolicyItemsString = policiesList
                .texts()
                .stream()
                .collect(Collectors.joining("\n"));
        List<String> actualPolicyItems = Arrays.asList(allPolicyItemsString.split("\n"));
        for (String expectedItem : policyItems) {
            Assertions.assertThat(actualPolicyItems).contains(expectedItem);
        }
    }

    public void checkLocationAmerica(String region) {
        epamMainPage.getOurLocationsAmericasTab().shouldBe(Condition.visible, Condition.enabled, Condition.interactable);
        Assertions.assertThat(epamMainPage.getOurLocationsAmericasTab().text()).contains(region);

    }

    public void checkLocationEmea(String region) {
        epamMainPage.getOurLocationsEmeaTab().shouldBe(Condition.visible, Condition.enabled, Condition.interactable);
        Assertions.assertThat(epamMainPage.getOurLocationsEmeaTab().text()).contains(region);

    }

    public void checkLocationApac(String region) {
        epamMainPage.getOurLocationsApacTab().shouldBe(Condition.visible, Condition.enabled, Condition.interactable);
        Assertions.assertThat(epamMainPage.getOurLocationsApacTab().text()).contains(region);

    }

    public void checkSearchFunction(String wordToSearch) {
        epamMainPage.getSearchIcon().shouldBe(Condition.interactable).click();
        epamMainPage.getMainPageSearchBox().sendKeys(wordToSearch);
        epamMainPage.getMainPageSearchBox().sendKeys(Keys.ENTER);

        waitForElementWithCondition(epamMainPage.getSearchedResult(), visible, 5);
        String expectedText = epamMainPage.getSearchResultsCounter().text();
        String resultSearch = epamMainPage.getSearchedResult().text();

        Assertions.assertThat(expectedText).contains(wordToSearch);
        Assertions.assertThat(resultSearch).contains(wordToSearch);
    }

}
