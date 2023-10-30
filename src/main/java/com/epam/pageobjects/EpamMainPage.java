package com.epam.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class EpamMainPage {

    private final SelenideElement themeSwitcherToggle = $x("(//div[@class='theme-switcher'])[2]");
    private final SelenideElement themeDarkMode = $x("//body[contains(@class, 'dark-mode')]");
    private final SelenideElement themeLightMode = $x("//body[contains(@class, 'light-mode')]");
    private final SelenideElement languageSelectorButton = $x("//button[@class='location-selector__button']");
    private final SelenideElement ukrainianLanguageChanger = $x("//a[@class='location-selector__link'][contains(.,'Україна (Українська)')]");
    private final ElementsCollection policiesList = $$x("//div[@class='policies']");
    private final SelenideElement ourLocationsAmericasTab = $x("//a[@data-item='0']");
    private final SelenideElement ourLocationsEmeaTab = $x("//a[@data-item='1']");
    private final SelenideElement ourLocationsApacTab = $x("//a[@data-item='2']");
    private final SelenideElement searchIcon = $x("//span[contains(@class,'search-icon')]");
    private final SelenideElement mainPageSearchBox = $x("//input[@id='new_form_search']");
    private final SelenideElement searchResultsCounter = $x("//h2[@class='search-results__counter']");
    private final SelenideElement searchedResult = $x("(//p[contains(@class,'search-results__description')])");

}


