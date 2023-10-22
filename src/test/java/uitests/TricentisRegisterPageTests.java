package uitests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.demowebshop.tricentis.ui.TricentisRegisterPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.BaseTest;

public class TricentisRegisterPageTests extends BaseTest {

    TricentisRegisterPage tricentisRegisterPage;
    @BeforeTest
    public void setup() {
        setUpUI();
        Configuration.baseUrl = tricentisMainPageBaseUrl;
        tricentisRegisterPage = new TricentisRegisterPage();
        Selenide.open(tricentisMainPageBaseUrl);

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
