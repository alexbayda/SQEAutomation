package ui;

import com.codeborne.selenide.Configuration;
import com.epam.ui.EpamContactUsPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.BaseTest;

public class EpamContactUsPageTests extends BaseTest {

    EpamContactUsPage epamAboutUsPage;

    @BeforeTest
    public void setup() {
        Configuration.baseUrl = contactUsPageBaseUrl;
        setUpUI();
        epamAboutUsPage = new EpamContactUsPage(contactUsPageBaseUrl);
    }

    @Test
    public void checkFormFieldsValidationTest(){
        epamAboutUsPage.checkformfieldsvalidation();
    }
}
