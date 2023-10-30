package com.tricentis.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
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
    private final ElementsCollection itemsBox = sortedProductGrid.$$(By.className("item-box"));
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

}



