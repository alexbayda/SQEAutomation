package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.Form;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TricentisMainPage {

    private final SelenideElement categoriesComputers = $x("//li[@class='inactive']//a[normalize-space()='Computers']");
    private final SelenideElement currentActiveCategory = $x("//li[@class='active']");
    private final SelenideElement categoriesBooks = $x("//li[@class='inactive']//a[normalize-space()='Books']");
    private final SelenideElement categoriesJewelery = $x("//li[@class='inactive']//a[normalize-space()='Jewelry']");
    private final SelenideElement sortingDropdown = $x("//select[@id='products-orderby']");
    private final SelenideElement sortedProductGrid = $x("//div[@class='product-grid']");
    private final SelenideElement productItem = $x("//div[@class='product-item']");
    private final SelenideElement itemsPerPageDropdown = $x("//select[@id='products-pagesize']");
    private final SelenideElement itemsPerPageDropdownChildOptionOne = $("#products-pagesize > option:nth-child(1)");
    private final List<SelenideElement> itemsBox = sortedProductGrid.$$(By.className("item-box"));
    private final SelenideElement addToWishlistButton = $("#add-to-wishlist-button-14");
    private final SelenideElement addToCartButton = $("#add-to-cart-button-13");
    private final SelenideElement wishlistNavigation = $x("//span[normalize-space()='Wishlist']");
    private final SelenideElement shoppingCartNavigation = $x("//span[normalize-space()='Shopping cart']");
    private final SelenideElement wishlistNavigationQuantity = $x("//span[@class='wishlist-qty']");
    private final SelenideElement cartNavigationQuantity = $x("//span[@class='cart-qty']");
    private final SelenideElement openedItemName = $x("//h1[@itemprop='name']");
    private final SelenideElement selectItemToDeleteCheckmark = $x("//input[@name='removefromcart']");
    private final SelenideElement updateShoppingCartButton = $x("//input[@name='updatecart']");
    private final SelenideElement orderSummaryContent = $x("//div[@class='order-summary-content']");
    private final SelenideElement termsAndConditionsCheckmark = $x("//input[@id='termsofservice']");
    private final SelenideElement checkoutButton = $x("//button[@id='checkout']");
    private final SelenideElement orderConfirmationButton = $x("//input[@value='Confirm']");
    private final SelenideElement successfulOrderConfirmation = $x("//strong[normalize-space()='Your order has been successfully processed!']");

    public void verifyComputersGroupHasThreeSubgroupsWithCorrectNames() {
        categoriesComputers.shouldHave(Condition.visible, Condition.enabled).click();
        System.out.println(currentActiveCategory.text());
        Assertions.assertThat(currentActiveCategory.text()).contains("Desktops").contains("Notebooks").contains("Accessories");
    }

    public void verifyAbilityToSortItems() {
        categoriesBooks.shouldHave(Condition.visible, Condition.enabled).click();
        sortingDropdown.shouldHave(Condition.visible, Condition.enabled);

        sortAndVerify("Name: A to Z");
        sortAndVerify("Name: Z to A");
        sortAndVerify("Price: Low to High");
        sortAndVerify("Price: High to Low");
    }

    private void sortAndVerify(String option) {
        sortingDropdown.selectOption(option);
        sortedProductGrid.shouldBe(Condition.visible);
        String[] productTexts = productItem.$$(By.xpath(".//h2")).texts().toArray(new String[0]);
        Assertions.assertThat(productTexts).isSorted();
    }

    public void verifyAbilityToChangingNumberOfItemsOnPage(int value) {
        categoriesBooks.shouldBe(Condition.visible, Condition.enabled).click();
        sortedProductGrid.shouldBe(Condition.visible);
        itemsPerPageDropdown.shouldBe(Condition.visible).click();

        itemsPerPageDropdownChildOptionOne.click();

        sortedProductGrid.shouldBe(Condition.visible);
        Assertions.assertThat(countItemsPerPage().size()).isEqualTo(value);
    }

    private List<SelenideElement> countItemsPerPage() {
        return itemsBox;
    }

    public void verifyAbilityToAddingItemsToWishlist() {
        categoriesJewelery.click();
        SelenideElement secondItem = itemsBox.get(1).shouldBe(Condition.visible, Condition.enabled);
        Selenide.executeJavaScript("arguments[0].querySelector('img').click();", secondItem);

        addToWishlistButton.click();
        Selenide.sleep(2000);
        String itemName = openedItemName.shouldBe(Condition.visible).text();

        Assertions.assertThat(wishlistNavigationQuantity.text()).contains("(1)");
        wishlistNavigation.click();

        SelenideElement wishlistProduct = $(By.className("wishlist-content")).$(By.linkText(itemName));
        Assertions.assertThat(wishlistProduct.exists()).isTrue();

    }

    public void verifyAbilityToAddingItemsToCart() {
        categoriesBooks.click();
        SelenideElement secondItem = itemsBox.get(0).shouldBe(Condition.visible, Condition.enabled);
        Selenide.executeJavaScript("arguments[0].querySelector('img').click();", secondItem);

        addToCartButton.click();
        Selenide.sleep(2000);
        String itemName = openedItemName.shouldBe(Condition.visible).text();

        Assertions.assertThat(cartNavigationQuantity.text()).contains("(1)");
        shoppingCartNavigation.click();
        SelenideElement cartProduct = $(By.linkText(itemName));
        Assertions.assertThat(cartProduct.exists()).isTrue();
    }

    public void verifyAbilityToRemoveItemsFromCart() {
        categoriesBooks.click();
        SelenideElement secondItem = itemsBox.get(0).shouldBe(Condition.visible, Condition.enabled);
        Selenide.executeJavaScript("arguments[0].querySelector('img').click();", secondItem);

        addToCartButton.click();
        Selenide.sleep(2000);
        String itemName = openedItemName.shouldBe(Condition.visible).text();

        Assertions.assertThat(cartNavigationQuantity.text()).contains("(1)");
        shoppingCartNavigation.click();
        SelenideElement cartProduct = $(By.linkText(itemName));
        Assertions.assertThat(cartProduct.exists()).isTrue();

        selectItemToDeleteCheckmark.shouldBe(Condition.visible, Condition.enabled).click();
        updateShoppingCartButton.shouldBe(Condition.visible, Condition.enabled).click();
        Assertions.assertThat(orderSummaryContent.text()).isEqualTo("Your Shopping Cart is empty!");
        shoppingCartNavigation.click();
        Assertions.assertThat(cartProduct.exists()).isFalse();
    }

    public void verifyAbilityToCheckoutAnItem() {
        verifyAbilityToAddingItemsToCart();
        termsAndConditionsCheckmark.click();
        checkoutButton.shouldBe(Condition.enabled).click();
        Form.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@example.com")
                .country("United States")
                .city("New York")
                .address("123 Main St")
                .postalCode("10001")
                .phoneNumber("555-123-4567")
                .build()
                .fillOutForm();
        orderConfirmationButton.click();
        Assertions.assertThat(successfulOrderConfirmation.text()).isEqualTo("Your order has been successfully processed!");
    }
}


