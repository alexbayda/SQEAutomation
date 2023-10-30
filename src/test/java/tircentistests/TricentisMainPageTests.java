package tircentistests;

import com.codeborne.selenide.Selenide;
import com.tricentis.actions.TricentisMainPageActions;
import com.tricentis.actions.TricentisRegisterPageActions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.util.List;

import static com.codeborne.selenide.Configuration.browser;
import static utils.ApplicationUrls.TRICENTIS_MAIN_PAGE_URL;
import static utils.TestDataFromFile.getTestDataFromFile;
import static utils.TestDataPaths.COMPUTERS_LIST;
import static utils.TestDataPaths.SORTING_OF_ITEMS;

public class TricentisMainPageTests extends BaseTest {

    TricentisMainPageActions tricentisMainPage;
    @BeforeMethod
    @Parameters("browser")
    public void setup() {
        setUpUI(browser);
        tricentisMainPage = new TricentisMainPageActions();
        Selenide.open(TRICENTIS_MAIN_PAGE_URL.getUrl());
    }

    @Test
    public void verifyComputersGroupHasThreeSubgroupsWithCorrectNamesTest(){
        tricentisMainPage.getComputersGroup();
        List<String> computerList = getTestDataFromFile(COMPUTERS_LIST.getPath());
        for(String computer : computerList){
            tricentisMainPage.verifyComputersGroupHasThreeSubgroupsWithCorrectNames(computer);
        }
    }

    @Test
    public void verifyAbilityToSortItemsTest(){
        List<String> sortBy = getTestDataFromFile(SORTING_OF_ITEMS.getPath());
        tricentisMainPage.navigateToCategoriesBooks();
        for (String sortOption : sortBy) {
            tricentisMainPage.verifyAbilityToSortItems(sortOption);
        }
    }

    @Test
    public void verifyAbilityToChangingNumberOfItemsOnPageTest(){
        tricentisMainPage.verifyAbilityToChangingNumberOfItemsOnPage(4);
    }

    @Test
    public void verifyAbilityToAddingItemsToWishlistTest(){
        tricentisMainPage.verifyAbilityToAddingItemsToWishlist();
    }

    @Test
    public void verifyAbilityToAddingItemsToCartTest(){
        tricentisMainPage.verifyAbilityToAddingItemsToCart();
    }

    @Test
    public void verifyAbilityToRemoveItemsFromCartTest(){
        tricentisMainPage.verifyAbilityToRemoveItemsFromCart();
    }

    @Test
    public void verifyAbilityToCheckoutAnItemTest(){
        TricentisRegisterPageActions tricentisRegisterPage = new TricentisRegisterPageActions();
        tricentisRegisterPage.registerRandomUser();
        tricentisRegisterPage.userLogin();
        tricentisMainPage.verifyAbilityToAddingItemsToCart();
        tricentisMainPage.checkOutItem();
        tricentisMainPage.verifyAbilityToCheckoutItem();
    }
}
