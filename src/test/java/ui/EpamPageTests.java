package ui;

import com.codeborne.selenide.Configuration;
import com.epam.ui.EpamMainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.BaseTest;


public class EpamPageTests extends BaseTest {


    EpamMainPage epamMainPage;
    @BeforeTest
    public void setup() {
        setUpUI();
        Configuration.baseUrl = mainPageBaseUrl;
        epamMainPage = new EpamMainPage(mainPageBaseUrl);
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
