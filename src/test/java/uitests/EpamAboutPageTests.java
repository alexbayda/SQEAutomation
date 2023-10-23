package uitests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Parameters;
import pageobjects.EpamAboutPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.BaseTest;

import static com.codeborne.selenide.Configuration.browser;
import static utils.ApplicationUrls.EPAM_ABOUT_US_PAGE_URL;
import static utils.ApplicationUrls.EPAM_MAIN_PAGE_URL;

public class EpamAboutPageTests extends BaseTest {

    EpamAboutPage epamAboutUsPage;

    @BeforeMethod
    @Parameters("browser")
    public void setup() {
        Configuration.baseUrl = EPAM_ABOUT_US_PAGE_URL.getUrl();
        setUpUI(browser);
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
