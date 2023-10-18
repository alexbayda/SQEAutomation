package org.saucelabs.ui;

import com.codeborne.selenide.*;
import io.qameta.allure.Flaky;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;

import java.util.*;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class EpamMainPage {

    private final SelenideElement themeSwitcherToggle = $x("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/section/div");
    private final SelenideElement darkMode = $x("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/div/div/nav/div/div/div/span");
    private final SelenideElement lightMode = $x("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/div/div/nav/div/div/div/span");
    private final SelenideElement languageSelectorEN = $x("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/ul/li[2]/div/div/button/span");
    private final SelenideElement ukrainianLanguageChanger = $x("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/ul/li[2]/div/nav/ul/li[6]/a");
    private final SelenideElement languageSelectorUA = $x("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/ul/li[2]/div/button");
    private final List<ElementsCollection> policiesList = Collections.singletonList($$x("//*[@id=\"wrapper\"]/div[3]/div[1]/footer/div/div/div[1]/div[2]"));
    private final SelenideElement ourLocationsAmericasTab = $x("//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]/div[1]/div/div/div[1]/a");
    private final SelenideElement ourLocationsEmeaTab = $x("//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]/div[1]/div/div/div[1]/a");
    private final SelenideElement ourLocationsApacTab = $x("//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]/div[1]/div/div/div[1]/a");
    private final SelenideElement searchIcon = $x("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/ul/li[3]/div/button/span[1]");
    private final SelenideElement mainPageSearchBox = $x("//*[@id=\"new_form_search\"]");
    private final SelenideElement searchResultsCounter = $x("//*[@id=\"main\"]/div[1]/div/section/div[2]/div[4]/section/h2");
    private final SelenideElement searchedResult = $x("//*[@id=\"main\"]/div[1]/div/section/div[2]/div[4]/section");



    public EpamMainPage(String url) {
        open(url);
    }

    public void checkTitleIsCorrect() {
        String expectedTitle = title();
        Assertions.assertThat(expectedTitle).isEqualTo("EPAM | Software Engineering & Product Development Services");
    }

    public boolean isLightMode() {
        return lightMode.exists();
    }

    public boolean isDarkMode() {
        return darkMode.exists();
    }

    public void checkLightDarkModeAbility() {
        boolean isInitiallyLightMode = isLightMode();
        boolean isInitiallyDarkMode = isDarkMode();
        if (isInitiallyDarkMode) {
            themeSwitcherToggle.click();
            Assertions.assertThat(isDarkMode()).isTrue();
        } else if (isInitiallyLightMode) {
            themeSwitcherToggle.click();
            Assertions.assertThat(isLightMode()).isTrue();
        }
    }

    public String getCurrentLanguageTextEN(){
        return languageSelectorEN.getText();
    }

    public String getCurrentLanguageTextUA(){
        return languageSelectorUA.getText();
    }

    public void checkToChangeLanguageToUa(){
        if(getCurrentLanguageTextEN().contains("EN")){
            languageSelectorEN.click();
            ukrainianLanguageChanger.click();
        }
        Assertions.assertThat(getCurrentLanguageTextUA()).contains("UA");
    }


    public void scrollToBottom() {
//        JavascriptExecutor js = (JavascriptExecutor) Selenide.driver();
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    @Flaky
    public void checkPoliciesListHasCorrectItems() {
        Assertions.assertThat(policiesList).isNotEmpty();

        List<String> allPolicyItems = policiesList.stream()
                .flatMap(policyCollection -> policyCollection.texts().stream())
                .collect(Collectors.toList());

        System.out.println(allPolicyItems);
        List<String> expectedPolicyItems = Arrays.asList("POLICIES", "INVESTORS", "OPEN SOURCE",
                "PRIVACY POLICY", "COOKIE POLICY", "APPLICANT PRIVACY NOTICE", "WEB ACCESSIBILITY");
        boolean allExpectedItemsFound = expectedPolicyItems.containsAll(allPolicyItems);
        Assertions.assertThat(allExpectedItemsFound).isTrue();
    }

    public void checkToSwitchLocationListByRegion(){
        ourLocationsAmericasTab.shouldBe(Condition.visible, Condition.enabled, Condition.interactable);
        ourLocationsEmeaTab.shouldBe(Condition.visible, Condition.enabled, Condition.interactable);
        ourLocationsApacTab.shouldBe(Condition.visible, Condition.enabled, Condition.interactable);
    }

    public void checkSearchFunction(String wordToSearch){
        searchIcon.shouldBe(Condition.interactable).click();
        mainPageSearchBox.sendKeys(wordToSearch);
        mainPageSearchBox.sendKeys(Keys.ENTER);
        String expectedText = searchResultsCounter.text();
        String resultSearch = searchedResult.text();
        Assertions.assertThat(expectedText).contains(wordToSearch);
        Assertions.assertThat(resultSearch).contains(wordToSearch);
    }



}

