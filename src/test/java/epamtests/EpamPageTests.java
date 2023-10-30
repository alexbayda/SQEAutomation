package epamtests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.epam.actions.EpamMainPageActions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.util.List;

import static com.codeborne.selenide.Configuration.browser;
import static utils.ApplicationUrls.EPAM_MAIN_PAGE_URL;
import static utils.TestDataFromFile.getTestDataFromFile;
import static utils.TestDataPaths.*;


public class EpamPageTests extends BaseTest {

    EpamMainPageActions epamMainPage;

    @BeforeMethod
    @Parameters("browser")
    public void setup() {
        setUpUI(browser);
        Configuration.baseUrl = EPAM_MAIN_PAGE_URL.getUrl();
        epamMainPage = new EpamMainPageActions();
        Selenide.open(EPAM_MAIN_PAGE_URL.getUrl());

    }

    @Test
    public void checkTitleIsCorrectTest() {
        List<String> expectedTitleList = getTestDataFromFile(MAIN_PAGE_TITLE.getPath());
        epamMainPage.checkTitleIsCorrect(expectedTitleList.get(0));
    }

    @Test
    public void checkLightDarkModeAbilityTest(){
        epamMainPage.checkLightDarkModeAbility();
    }

    @Test
    public void checkToChangeLanguageToUaTest(){
        epamMainPage.checkToChangeLanguage("UA");
    }

    @Test
    public void checkPoliciesListHasCorrectItemsTest() {
        epamMainPage.checkPoliciesListHasCorrectItems(getTestDataFromFile(POLICIES_LIST.getPath()));
    }

    @Test
    public void checkToSwitchLocationListByRegionTest(){
        List<String> listOfCountries = getTestDataFromFile(REGION_LIST.getPath());
        epamMainPage.checkLocationAmerica(listOfCountries.get(0));
        epamMainPage.checkLocationEmea(listOfCountries.get(1));
        epamMainPage.checkLocationApac(listOfCountries.get(2));
    }

    @Test
    public void checkSearchFunctionTest(){
        epamMainPage.checkSearchFunction("AI");
    }
}
