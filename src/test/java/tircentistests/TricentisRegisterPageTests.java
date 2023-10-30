package tircentistests;

import com.codeborne.selenide.Selenide;
import com.tricentis.actions.TricentisRegisterPageActions;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.BaseTest;

import static com.codeborne.selenide.Configuration.browser;
import static utils.ApplicationUrls.TRICENTIS_MAIN_PAGE_URL;

public class TricentisRegisterPageTests extends BaseTest {

    TricentisRegisterPageActions tricentisRegisterPage;
    @BeforeMethod
    @Parameters("browser")
    public void setup() {
        setUpUI(browser);
        tricentisRegisterPage = new TricentisRegisterPageActions();
        Selenide.open(TRICENTIS_MAIN_PAGE_URL.getUrl());

    }

    @Test
    public void verifyThatAllowsRegisterUserTest(){
        tricentisRegisterPage.registerRandomUser();
        tricentisRegisterPage.verifyValidUserRegistration();
    }

    @Test
    public void verifyValidUserLoginTest(){
        tricentisRegisterPage.registerRandomUser();
        tricentisRegisterPage.userLogin();
        tricentisRegisterPage.verifyValidUserLogin();
    }

}
