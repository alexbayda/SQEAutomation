package uitests;

import com.codeborne.selenide.Selenide;
import org.demowebshop.tricentis.ui.pageObject.TricentisMainPage;
import org.demowebshop.tricentis.ui.pageObject.TricentisRegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.BaseTest;

import static utils.ApplicationUrls.TRICENTIS_MAIN_PAGE_URL;

public class TricentisMainPageTests extends BaseTest {

    TricentisMainPage tricentisMainPage;
    @BeforeMethod
    public void setup() {
        setUpUI();
        tricentisMainPage = new TricentisMainPage();
        Selenide.open(TRICENTIS_MAIN_PAGE_URL.getUrl());
    }

    @Test
    public void verifyComputersGroupHasThreeSubgroupsWithCorrectNamesTest(){
        tricentisMainPage.verifyComputersGroupHasThreeSubgroupsWithCorrectNames();
    }

    @Test
    public void verifyAbilityToSortItemsTest(){
        tricentisMainPage.verifyAbilityToSortItems();
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
        TricentisRegisterPage tricentisRegisterPage = new TricentisRegisterPage();
        tricentisRegisterPage.verifyValidUserLogin();
        tricentisMainPage.verifyAbilityToCheckoutAnItem();
    }
}
