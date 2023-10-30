package epamtests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.epam.actions.EpamAboutPageActions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.util.List;

import static com.codeborne.selenide.Configuration.browser;
import static utils.ApplicationUrls.EPAM_ABOUT_US_PAGE_URL;
import static utils.ApplicationUrls.EPAM_MAIN_PAGE_URL;
import static utils.TestDataFromFile.getTestDataFromFile;
import static utils.TestDataPaths.CORP_OVERVIEW_FILE_NAME;

public class EpamAboutPageTests extends BaseTest {

    EpamAboutPageActions epamAboutUsPage;

    @BeforeMethod
    @Parameters("browser")
    public void setup() {
        Configuration.baseUrl = EPAM_ABOUT_US_PAGE_URL.getUrl();
        setUpUI(browser);
        epamAboutUsPage = new EpamAboutPageActions();
        Selenide.open(EPAM_ABOUT_US_PAGE_URL.getUrl());
    }

    @Test
    public void checkFormFieldsValidationTest() {
        epamAboutUsPage.navigateToCompanyLogo();
        epamAboutUsPage.checkCompanyLogoLeadsToMainPage(EPAM_MAIN_PAGE_URL.getUrl());
    }

    @Test
    public void checkThatAllowsToDownloadReportTest() {
        epamAboutUsPage.downloadCorporateOverviewFile();
        List<String> expectedFileName = getTestDataFromFile(CORP_OVERVIEW_FILE_NAME.getPath());
        epamAboutUsPage.checkThatAllowsToDownloadReport(expectedFileName.get(0));
    }
}
