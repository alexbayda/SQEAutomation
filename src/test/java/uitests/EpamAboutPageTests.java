package uitests;

import com.codeborne.selenide.Configuration;
import com.epam.ui.EpamAboutPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.BaseTest;

public class EpamAboutPageTests extends BaseTest {

    EpamAboutPage epamAboutUsPage;

    @BeforeTest
    public void setup() {
        Configuration.baseUrl = epamAboutPageBaseUrl;
        setUpUI();
        epamAboutUsPage = new EpamAboutPage(epamAboutPageBaseUrl);
    }

    @Test
    public void checkFormFieldsValidationTest(){
        epamAboutUsPage.checkCompanyLogoLeadsToMainPage(epamMainPageBaseUrl);
    }

    @Test
    public void checkThatAllowsToDownloadReportTest() {
        epamAboutUsPage.checkThatAllowsToDownloadReport();
    }
}
