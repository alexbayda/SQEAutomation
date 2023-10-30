package com.epam.actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.epam.pageobjects.EpamAboutPage;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.awaitility.Awaitility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class EpamAboutPageActions {

    EpamAboutPage epamAboutPage = new EpamAboutPage();

    public void navigateToCompanyLogo() {
        epamAboutPage.getCompanyLogo().shouldBe(Condition.visible, Condition.enabled);
        epamAboutPage.getCompanyLogo().click();
    }

    public void checkCompanyLogoLeadsToMainPage(String expectedUrl) {
        String currentUrl = Selenide.webdriver().driver().getCurrentFrameUrl();
        Assertions.assertThat(currentUrl).isEqualTo(expectedUrl);
    }

    public void downloadCorporateOverviewFile() {
        epamAboutPage.getCookieAccept().click();
        epamAboutPage.getCorporateOverviewDownloadButton().shouldBe(Condition.visible, Condition.enabled);
        epamAboutPage.getCorporateOverviewDownloadButton().click();
    }

    public void checkThatAllowsToDownloadReport(String expectedFileName) {
        File downloadedFile = null;
        try {
            downloadedFile = new File(epamAboutPage.getCorporateOverviewHref().download().getAbsolutePath());
            Awaitility.await().atMost(15, TimeUnit.SECONDS).until(downloadedFile::exists);
            Assertions.assertThat(downloadedFile).exists().hasName(expectedFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            deleteDownloadedFile(downloadedFile);
        }
    }

    private void deleteDownloadedFile(File file) {
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                log.info("File deleted successfully");
            } else {
                log.error("Failed to delete the file");
            }
        }
    }
}

