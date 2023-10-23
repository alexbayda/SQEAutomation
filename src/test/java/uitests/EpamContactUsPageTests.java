package uitests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Parameters;
import pageobjects.EpamContactUsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.BaseTest;

import static com.codeborne.selenide.Configuration.browser;
import static utils.ApplicationUrls.EPAM_CONTACT_US_PAGE_URL;

public class EpamContactUsPageTests extends BaseTest {

    EpamContactUsPage epamAboutUsPage;

    @BeforeMethod
    @Parameters("browser")
    public void setup() {
        Configuration.baseUrl = EPAM_CONTACT_US_PAGE_URL.getUrl();
        setUpUI(browser);
        epamAboutUsPage = new EpamContactUsPage(EPAM_CONTACT_US_PAGE_URL.getUrl());
    }

    @Test
    public void checkFormFieldsValidationTest() {
        epamAboutUsPage.checkFormFieldsValidation();
    }
}
