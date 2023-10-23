package uitests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Parameters;
import pageobjects.EpamMainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.BaseTest;

import static com.codeborne.selenide.Configuration.browser;
import static utils.ApplicationUrls.EPAM_MAIN_PAGE_URL;


public class EpamPageTests extends BaseTest {

    EpamMainPage epamMainPage;

    @BeforeMethod
    @Parameters("browser")
    public void setup() {
        setUpUI(browser);
        Configuration.baseUrl = EPAM_MAIN_PAGE_URL.getUrl();
        epamMainPage = new EpamMainPage(EPAM_MAIN_PAGE_URL.getUrl());
    }

    @Test
    public void checkTitleIsCorrectTest() {
        epamMainPage.checkTitleIsCorrect();
    }

    @Test
    public void checkLightDarkModeAbilityTest(){
        epamMainPage.checkLightDarkModeAbility();
    }

    @Test
    public void checkToChangeLanguageToUaTest(){
        epamMainPage.checkToChangeLanguageToUa();
    }

    @Test
    public void checkPoliciesListHasCorrectItemsTest(){
        epamMainPage.checkPoliciesListHasCorrectItems();
    }

    @Test
    public void checkToSwitchLocationListByRegionTest(){
        epamMainPage.checkToSwitchLocationListByRegion();
    }

    @Test
    public void checkSearchFunctionTest(){
        epamMainPage.checkSearchFunction("AI");
    }
}
