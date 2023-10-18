package ui;

import com.codeborne.selenide.Configuration;
import com.epam.ui.EpamAboutPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.BaseTest;

public class EpamAboutPageTests extends BaseTest {

    EpamAboutPage epamAboutUsPage;

    @BeforeTest
    public void setup() {
        Configuration.baseUrl = aboutPageBaseUrl;
        setUpUI();
        epamAboutUsPage = new EpamAboutPage(aboutPageBaseUrl);
    }

    @Test
    public void checkFormFieldsValidationTest(){
        epamAboutUsPage.checkCompanyLogoLeadsToMainPage(mainPageBaseUrl);
    }

    @Test
    public void checkThatAllowsToDownloadReportTest() {
        epamAboutUsPage.checkThatAllowsToDownloadReport();
    }
}
