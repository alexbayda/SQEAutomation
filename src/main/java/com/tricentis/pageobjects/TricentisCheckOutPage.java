package com.tricentis.pageobjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class TricentisCheckOutPage {
    private final SelenideElement firstNameInput = $("#BillingNewAddress_FirstName");
    private final SelenideElement lastNameInput = $("#BillingNewAddress_LastName");
    private final SelenideElement emailInput = $("#BillingNewAddress_Email");
    private final SelenideElement countrySelect = $("#BillingNewAddress_CountryId");
    private final SelenideElement cityInput = $("#BillingNewAddress_City");
    private final SelenideElement addressInput = $("#BillingNewAddress_Address1");
    private final SelenideElement postalCodeInput = $("#BillingNewAddress_ZipPostalCode");
    private final SelenideElement phoneNumberInput = $("#BillingNewAddress_PhoneNumber");
    private final SelenideElement saveBillingButton = $("input[onclick='Billing.save()']");
    private final SelenideElement saveShippingButton = $("input[onclick='Shipping.save()']");
    private final SelenideElement shippingMethodNextButton = $("input[class='button-1 shipping-method-next-step-button']");
    private final SelenideElement paymentMethodNextButton = $("input[class='button-1 payment-method-next-step-button']");
    private final SelenideElement paymentInfoNextButton = $("input[class='button-1 payment-info-next-step-button");

}
