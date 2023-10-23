package uitests;

import com.codeborne.selenide.Selenide;
import pageobjects.TricentisRegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.BaseTest;

import static utils.ApplicationUrls.TRICENTIS_MAIN_PAGE_URL;

public class TricentisRegisterPageTests extends BaseTest {

    TricentisRegisterPage tricentisRegisterPage;
    @BeforeMethod
    public void setup() {
        setUpUI();
        tricentisRegisterPage = new TricentisRegisterPage();
        Selenide.open(TRICENTIS_MAIN_PAGE_URL.getUrl());

    }

    @Test
    public void verifyThatAllowsRegisterUserTest(){
        tricentisRegisterPage.verifyValidUserRegistration();
    }

    @Test
    public void verifyValidUserLoginTest(){
        tricentisRegisterPage.verifyValidUserLogin();
    }

}
