package com.epam.pageobjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class EpamAboutPage {


    private final SelenideElement companyLogo = $x("(//img[@class='header__logo header__logo-light'])[1]");
    private final SelenideElement corporateOverviewDownloadButton = $x("//*[@id='main']/div[1]/div[5]/section/div[2]/div/div/div[1]/div/div[3]/div/a");
    private final SelenideElement corporateOverviewHref = $x("//a[contains(@href,'EPAM_Corporate_Overview')]");
    private final SelenideElement cookieAccept = $x("//button[@id='onetrust-accept-btn-handler']");

}

