package uitests;

import com.codeborne.selenide.Configuration;
import com.epam.ui.pageObject.EpamMainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.BaseTest;

import static utils.ApplicationUrls.EPAM_MAIN_PAGE_URL;


public class EpamPageTests extends BaseTest {

    EpamMainPage epamMainPage;

    @BeforeMethod
    public void setup() {
        setUpUI();
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
