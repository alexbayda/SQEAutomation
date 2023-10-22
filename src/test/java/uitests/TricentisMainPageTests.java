package uitests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.demowebshop.tricentis.ui.TricentisMainPage;
import org.demowebshop.tricentis.ui.TricentisRegisterPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.BaseTest;

public class TricentisMainPageTests extends BaseTest {

    TricentisMainPage tricentisMainPage;
    @BeforeTest
    public void setup() {
        setUpUI();
        Configuration.baseUrl = tricentisMainPageBaseUrl;
        tricentisMainPage = new TricentisMainPage();
        Selenide.open(tricentisMainPageBaseUrl);
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
