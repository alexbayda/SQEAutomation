package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class EpamMainPage {

    private final SelenideElement themeSwitcherToggle = $x("(//div[@class='theme-switcher'])[2]");
    private final SelenideElement darkMode = $x("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/div/div/nav/div/div/div/span");
    private final SelenideElement lightMode = $x("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/div/div/nav/div/div/div/span");
    private final SelenideElement languageSelectorButton = $x("//button[@class='location-selector__button']");
    private final SelenideElement ukrainianLanguageChanger = $x("//a[@class='location-selector__link'][contains(.,'Україна (Українська)')]");
    private final List<ElementsCollection> policiesList = Collections.singletonList($$x("//div[@class='policies']"));
    private final SelenideElement ourLocationsAmericasTab = $x("//a[@data-item='0']");
    private final SelenideElement ourLocationsEmeaTab = $x("//a[@data-item='1']");
    private final SelenideElement ourLocationsApacTab = $x("//a[@data-item='2']");
    private final SelenideElement searchIcon = $x("//span[contains(@class,'search-icon')]");
    private final SelenideElement mainPageSearchBox = $x("//input[@id='new_form_search']");
    private final SelenideElement searchResultsCounter = $x("//h2[@class='search-results__counter']");
    private final SelenideElement searchedResult = $x("(//p[contains(@class,'search-results__description')])");


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

    public String getCurrentLanguageText() {
        return languageSelectorButton.getText();
    }

    public void checkToChangeLanguageToUa() {
        if (getCurrentLanguageText().contains("EN")) {
            languageSelectorButton.click();
            ukrainianLanguageChanger.click();
        }
        Assertions.assertThat(getCurrentLanguageText()).contains("UA");
    }

    public void checkPoliciesListHasCorrectItems() {
        List<String> expectedPolicyItems = Arrays.asList("INVESTORS", "COOKIE POLICY",
                "OPEN SOURCE", "APPLICANT PRIVACY NOTICE", "PRIVACY POLICY", "WEB ACCESSIBILITY");
        Assertions.assertThat(policiesList).isNotEmpty();
        String allPolicyItemsString = policiesList.stream()
                .flatMap(policyCollection -> policyCollection.texts().stream())
                .collect(Collectors.joining());
        for (String expectedItem : expectedPolicyItems) {
            Assertions.assertThat(allPolicyItemsString).as(expectedItem).contains(expectedItem);
        }
    }

    public void checkToSwitchLocationListByRegion() {
        ourLocationsAmericasTab.shouldBe(Condition.visible, Condition.enabled, Condition.interactable);
        Assertions.assertThat(ourLocationsAmericasTab.text()).contains("AMERICA");
        ourLocationsEmeaTab.shouldBe(Condition.visible, Condition.enabled, Condition.interactable);
        Assertions.assertThat(ourLocationsEmeaTab.text()).contains("EMEA");
        ourLocationsApacTab.shouldBe(Condition.visible, Condition.enabled, Condition.interactable);
        Assertions.assertThat(ourLocationsApacTab.text()).contains("APAC");

    }

    public void checkSearchFunction(String wordToSearch) {
        searchIcon.shouldBe(Condition.interactable).click();
        mainPageSearchBox.sendKeys(wordToSearch);
        mainPageSearchBox.sendKeys(Keys.ENTER);
        Selenide.sleep(5000);
        String expectedText = searchResultsCounter.text();
        String resultSearch = searchedResult.shouldBe(Condition.visible).text();
        Assertions.assertThat(expectedText).contains(wordToSearch);
        Assertions.assertThat(resultSearch).contains(wordToSearch);
    }


}


