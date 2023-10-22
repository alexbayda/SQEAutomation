package com.tricentis.demowebshop.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.epam.utils.Page;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.epam.utils.RandomSelector.getRandom;
import static com.epam.utils.RandomUserGenerator.getRandomGenerateUser;
import static com.epam.utils.RandomUserGenerator.getRandomGeneratedEmail;

@Page(url= "slashhuynya")
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
        Assertions.assertThat(countItemsPerPage().size()).isEqualTo(4);
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
        fillOutForm();
        orderConfirmationButton.click();
        Assertions.assertThat(successfulOrderConfirmation.text()).isEqualTo("Your order has been successfully processed!");
    }

    private void fillOutForm(){
        Selenide.$(By.id("BillingNewAddress_FirstName")).setValue("John");
        Selenide.$(By.id("BillingNewAddress_LastName")).setValue("Doe");
        Selenide.$(By.id("BillingNewAddress_Email")).setValue("johndoe@example.com");
        Selenide.$(By.id("BillingNewAddress_CountryId")).selectOption("United States");
        Selenide.$(By.id("BillingNewAddress_City")).setValue("New York");
        Selenide.$(By.id("BillingNewAddress_Address1")).setValue("123 Main St");
        Selenide.$(By.id("BillingNewAddress_ZipPostalCode")).setValue("10001");
        Selenide.$(By.id("BillingNewAddress_PhoneNumber")).setValue("555-123-4567");

        Selenide.$(("input[onclick='Billing.save()']")).click();
        Selenide.$(("input[onclick='Shipping.save()']")).click();

//        Selenide.$(By.name("shippingmethod")).selectRadio("Ground");
        Selenide.$(("input[class='button-1 shipping-method-next-step-button']")).click();


//        Selenide.$("#checkout-step-payment-method").selectRadio("Credit Card");
        Selenide.$(("input[class='button-1 payment-method-next-step-button']")).click();

//        Selenide.$(By.id("CreditCardType")).selectOption("Visa");
//        Selenide.$(By.id("CardholderName")).setValue("John Doe");
//        Selenide.$(By.id("CardNumber")).setValue("4917484589897107");
//        Selenide.$(By.id("ExpireYear")).selectOption("2024");
//        Selenide.$(By.id("ExpireMonth")).selectOption("6");
//        Selenide.$(By.id("CardCode")).setValue("123");
        Selenide.$(("input[class='button-1 payment-info-next-step-button']")).click();
    }
}



