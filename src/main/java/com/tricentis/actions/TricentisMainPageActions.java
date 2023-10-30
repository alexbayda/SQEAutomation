package com.tricentis.actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.tricentis.pageobjects.TricentisCheckOutPage;
import com.tricentis.pageobjects.TricentisMainPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static utils.CustomWaiter.waitForElementWithCondition;
import static utils.RandomGenerator.*;

public class TricentisMainPageActions {

    TricentisMainPage tricentisMainPage = new TricentisMainPage();
    TricentisCheckOutPage tricentisCheckOutPage = new TricentisCheckOutPage();

    public void verifyComputersGroupHasThreeSubgroupsWithCorrectNames(String computer) {
        Assertions.assertThat(tricentisMainPage.getCurrentActiveCategory().text())
                .contains(computer);
    }

    public void getComputersGroup() {
        tricentisMainPage.getCategoriesComputers().shouldHave(visible, Condition.enabled);
        tricentisMainPage.getCategoriesComputers().click();
    }

    public void verifyAbilityToSortItems(String sortOption) {
        selectSortingOption(sortOption);

        tricentisMainPage.getSortedProductGrid().shouldBe(visible);
        String[] productTexts = tricentisMainPage.getProductItem()
                .$$(By.xpath(".//h2")).texts().toArray(new String[0]);
        Assertions.assertThat(productTexts).isSorted();
    }

    public void navigateToCategoriesBooks() {
        tricentisMainPage.getCategoriesBooks().shouldHave(visible, Condition.enabled);
        tricentisMainPage.getCategoriesBooks().click();
    }

    private void selectSortingOption(String option) {
        tricentisMainPage.getSortingDropdown().shouldHave(visible, Condition.enabled);
        tricentisMainPage.getSortingDropdown().selectOption(option);
    }

    public void verifyAbilityToChangingNumberOfItemsOnPage(int value) {
        tricentisMainPage.getCategoriesBooks().shouldBe(visible, Condition.enabled);
        tricentisMainPage.getCategoriesBooks().click();
        tricentisMainPage.getSortedProductGrid().shouldBe(visible);
        tricentisMainPage.getItemsPerPageDropdown().shouldBe(visible).click();

        tricentisMainPage.getItemsPerPageDropdownChildOptionOne().click();

        tricentisMainPage.getSortedProductGrid().shouldBe(visible);
        Assertions.assertThat(countItemsPerPage().size()).isEqualTo(value);
    }

    private List<SelenideElement> countItemsPerPage() {
        return tricentisMainPage.getItemsBox();
    }

    public void verifyAbilityToAddingItemsToWishlist() {
        tricentisMainPage.getCategoriesJewelery().click();
        SelenideElement secondItem = tricentisMainPage.getItemsBox().get(1).shouldBe(visible, Condition.enabled);
        Selenide.executeJavaScript("arguments[0].querySelector('img').click();", secondItem);

        tricentisMainPage.getAddToWishlistButton().click();
        String itemName = tricentisMainPage.getOpenedItemName().text();

        waitForElementWithCondition(tricentisMainPage.getWishlistNavigationQuantity(), text("(1)"), 5);
        tricentisMainPage.getWishlistNavigation().click();

        SelenideElement wishlistProduct = $(By.className("wishlist-content")).$(By.linkText(itemName));
        Assertions.assertThat(wishlistProduct.exists()).isTrue();

    }

    public void verifyAbilityToAddingItemsToCart() {
        tricentisMainPage.getCategoriesBooks().click();
        SelenideElement secondItem = tricentisMainPage.getItemsBox().get(0).shouldBe(visible, Condition.enabled);
        Selenide.executeJavaScript("arguments[0].querySelector('img').click();", secondItem);

        tricentisMainPage.getAddToCartButton().click();
        waitForElementWithCondition(tricentisMainPage.getOpenedItemName(), visible, 5);

        String itemName = tricentisMainPage.getOpenedItemName().text();
        waitForElementWithCondition(tricentisMainPage.getCartNavigationQuantity(), text("(1)"), 5);
        tricentisMainPage.getShoppingCartNavigation().click();
        SelenideElement cartProduct = $(By.linkText(itemName));
        Assertions.assertThat(cartProduct.exists()).isTrue();
    }

    public void verifyAbilityToRemoveItemsFromCart() {
        tricentisMainPage.getCategoriesBooks().click();
        SelenideElement secondItem = tricentisMainPage.getItemsBox().get(0).shouldBe(visible, Condition.enabled);
        Selenide.executeJavaScript("arguments[0].querySelector('img').click();", secondItem);

        tricentisMainPage.getAddToCartButton().click();

        String itemName = tricentisMainPage.getOpenedItemName().shouldBe(visible).text();

        waitForElementWithCondition(tricentisMainPage.getCartNavigationQuantity(), text("(1)"), 5);
        tricentisMainPage.getShoppingCartNavigation().click();
        SelenideElement cartProduct = $(By.linkText(itemName));
        Assertions.assertThat(cartProduct.exists()).isTrue();

        tricentisMainPage.getSelectItemToDeleteCheckmark().shouldBe(visible, Condition.enabled).click();
        tricentisMainPage.getUpdateShoppingCartButton().shouldBe(visible, Condition.enabled).click();
        Assertions.assertThat(tricentisMainPage.getOrderSummaryContent().text()).isEqualTo("Your Shopping Cart is empty!");
        tricentisMainPage.getShoppingCartNavigation().click();
        Assertions.assertThat(cartProduct.exists()).isFalse();
    }

    public void checkOutItem() {
        tricentisMainPage.getTermsAndConditionsCheckmark().click();
        tricentisMainPage.getCheckoutButton().shouldBe(Condition.enabled).click();
        fillOutForm();
        tricentisMainPage.getOrderConfirmationButton().click();
    }

    public void verifyAbilityToCheckoutItem() {
        Assertions.assertThat(tricentisMainPage.getSuccessfulOrderConfirmation()
                .text()).isEqualTo("Your order has been successfully processed!");
    }

    private void fillOutForm() {
        tricentisCheckOutPage.getFirstNameInput().setValue(generateRandomString());
        tricentisCheckOutPage.getLastNameInput().setValue(generateRandomString());
        tricentisCheckOutPage.getEmailInput().setValue(getRandomGeneratedEmail());
        tricentisCheckOutPage.getCountrySelect().selectOption("United States");
        tricentisCheckOutPage.getCityInput().setValue(generateRandomString());
        tricentisCheckOutPage.getAddressInput().setValue(generateRandomString());
        tricentisCheckOutPage.getPostalCodeInput().setValue(generateRandomIntAsString(5));
        tricentisCheckOutPage.getPhoneNumberInput().setValue(generateRandomIntAsString(10));
        tricentisCheckOutPage.getSaveBillingButton().click();
        tricentisCheckOutPage.getSaveShippingButton().click();
        tricentisCheckOutPage.getShippingMethodNextButton().click();
        tricentisCheckOutPage.getPaymentMethodNextButton().click();
        tricentisCheckOutPage.getPaymentInfoNextButton().click();
    }
}
