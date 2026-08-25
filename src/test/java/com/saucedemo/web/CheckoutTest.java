package com.saucedemo.web;

import com.saucedemo.web.pages.CartPage;
import com.saucedemo.web.pages.CheckoutPage;
import com.saucedemo.web.pages.ProductPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void verifyCheckoutFormPageLoad(){
        ProductPage productPage = login();
        CheckoutPage checkoutPage = productPage.getCart().clickCartIcon()
                .clickCheckoutButton();
        checkoutPage.waitForPageLoad();
        assertThat(checkoutPage.getCheckoutFormLocator()).isVisible();
        assertThat(checkoutPage.getCheckoutTitleLocator()).containsText("Checkout: Your Information");
        assertThat(checkoutPage.getCheckoutContinueButton()).isVisible();
        assertThat(checkoutPage.getCheckoutCancelButton()).isVisible();
        assertThat(checkoutPage.getCheckoutFirstNameField()).isVisible();
        assertThat(checkoutPage.getCheckoutLastNameField()).isVisible();
        assertThat(checkoutPage.getCheckoutPostalCodeField()).isVisible();
    }

    @Test(groups = {"smoke"})
    public void verifyRequiredFieldsValidation(){
        ProductPage productPage = login();
        CheckoutPage checkoutPage = productPage.getCart().clickCartIcon()
                .clickCheckoutButton();
        checkoutPage.clickCheckoutContinueButton();
        assertThat(checkoutPage.getErrorMessageLocator()).containsText("Error: First Name is required");
        checkoutPage.fillCheckoutFirstName("John");
        checkoutPage.clickCheckoutContinueButton();
        assertThat(checkoutPage.getErrorMessageLocator()).containsText("Error: Last Name is required");
        checkoutPage.fillCheckoutLastName("Doe");
        checkoutPage.clickCheckoutContinueButton();
        assertThat(checkoutPage.getErrorMessageLocator()).containsText("Error: Postal Code is required");
        checkoutPage.fillCheckoutPostalCode("12345");
    }

    @Test(groups = {"smoke"})
    public void verifyValidCheckoutInformation(){
        ProductPage productPage = login();
        CheckoutPage checkoutPage = productPage.getCart().clickCartIcon()
                .clickCheckoutButton();
        checkoutPage.fillCheckoutFirstName("John")
                .fillCheckoutLastName("Doe")
                .fillCheckoutPostalCode("12345")
                .clickCheckoutContinueButton();
        assertThat(checkoutPage.getCheckoutOverviewTitleLocator()).containsText("Checkout: Overview");
    }

    @Test(groups = {"smoke"})
    public void verifyCancelButtonFunctionality() {
        ProductPage productPage = login();

        CartPage cartPage = productPage.getCart()
                .clickCartIcon();

        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();

        checkoutPage.clickCancelButton();

        assertThat(cartPage.getCartTitleLocator())
                .containsText("Your Cart");
    }

    @Test
    public void verifyCorrectProductDisplay(){
        ProductPage productPage = login();
        CheckoutPage checkoutPage = productPage.getCart().clickCartIcon()
                .clickCheckoutButton();
        assertThat(checkoutPage.getCheckoutCancelButton()).isVisible();
        assertThat(checkoutPage.getCheckoutFinishButton()).isVisible();
        assertThat(checkoutPage.getCheckoutOverviewTitleLocator()).containsText("Checkout: Overview");
    }

    @Test
    public void verifyFinishButtonFunctionality(){
        ProductPage productPage = login();
        CheckoutPage checkoutPage = productPage.getCart().clickCartIcon()
                .clickCheckoutButton();
        checkoutPage.fillCheckoutFirstName("John")
                .fillCheckoutLastName("Doe")
                .fillCheckoutPostalCode("12345")
                .clickCheckoutContinueButton()
                .clickCheckoutFinishButton();
        assertThat(checkoutPage.getCheckoutCompleteHeading()).containsText("THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void verifyCancelButtonRedirectsToInventoryPage(){
        ProductPage productPage = login();
        CheckoutPage checkoutPage = productPage.getCart().clickCartIcon()
                .clickCheckoutButton();
        checkoutPage.clickCancelButton();
        assertThat(checkoutPage.getProductTitleLocator()).containsText("Products");
    }
}
