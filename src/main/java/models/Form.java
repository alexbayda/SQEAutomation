package models;

import com.codeborne.selenide.Selenide;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Form {

    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String city;
    private String address;
    private String postalCode;
    private String phoneNumber;

    public void fillOutForm() {
        Selenide.$(By.id("BillingNewAddress_FirstName")).setValue(firstName);
        Selenide.$(By.id("BillingNewAddress_LastName")).setValue(lastName);
        Selenide.$(By.id("BillingNewAddress_Email")).setValue(email);
        Selenide.$(By.id("BillingNewAddress_CountryId")).selectOption(country);
        Selenide.$(By.id("BillingNewAddress_City")).setValue(city);
        Selenide.$(By.id("BillingNewAddress_Address1")).setValue(address);
        Selenide.$(By.id("BillingNewAddress_ZipPostalCode")).setValue(postalCode);
        Selenide.$(By.id("BillingNewAddress_PhoneNumber")).setValue(phoneNumber);
        Selenide.$(("input[onclick='Billing.save()']")).click();
        Selenide.$(("input[onclick='Shipping.save()']")).click();
        Selenide.$(("input[class='button-1 shipping-method-next-step-button']")).click();
        Selenide.$(("input[class='button-1 payment-method-next-step-button']")).click();
        Selenide.$(("input[class='button-1 payment-info-next-step-button']")).click();
    }
}
