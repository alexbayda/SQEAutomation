package uitests;

import com.codeborne.selenide.Configuration;
import com.epam.ui.pageObject.EpamAboutPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.BaseTest;

import static utils.ApplicationUrls.EPAM_ABOUT_US_PAGE_URL;
import static utils.ApplicationUrls.EPAM_MAIN_PAGE_URL;

public class EpamAboutPageTests extends BaseTest {

    EpamAboutPage epamAboutUsPage;

    @BeforeMethod
    public void setup() {
        Configuration.baseUrl = EPAM_ABOUT_US_PAGE_URL.getUrl();
        setUpUI();
        epamAboutUsPage = new EpamAboutPage(EPAM_ABOUT_US_PAGE_URL.getUrl());
    }

    @Test
    public void checkFormFieldsValidationTest() {
        epamAboutUsPage.checkCompanyLogoLeadsToMainPage(EPAM_MAIN_PAGE_URL.getUrl());
    }

    @Test
    public void checkThatAllowsToDownloadReportTest() {
        epamAboutUsPage.checkThatAllowsToDownloadReport();
    }
}
