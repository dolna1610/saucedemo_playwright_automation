package com.saucedemo.web;

import org.testng.annotations.Test;

public class OrderCompletionTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void verifyCheckoutPageLoad() {
        login()
                .getCart().clickCartIcon()
                .clickCheckoutButton()
                .fillCheckoutFirstName("John")
                .fillCheckoutLastName("Doe")
                .fillCheckoutPostalCode("12345")
                .clickCheckoutContinueButton()
                .clickCheckoutFinishButton();
    }

    @Test(groups = {"smoke"})
    public void verifyOrderCompletionPageLoad() {
        login()
                .getCart().clickCartIcon()
                .clickCheckoutButton()
                .fillCheckoutFirstName("John")
                .fillCheckoutLastName("Doe")
                .fillCheckoutPostalCode("12345")
                .clickCheckoutContinueButton()
                .clickCheckoutFinishButton()
                .getCheckoutCompleteHeading();
    }

    @Test(groups = {"smoke"})
    public void verifyBackHomeButtonFunctionality() {
        login()
                .getCart().clickCartIcon()
                .clickCheckoutButton()
                .fillCheckoutFirstName("John")
                .fillCheckoutLastName("Doe")
                .fillCheckoutPostalCode("12345")
                .clickCheckoutContinueButton()
                .clickCheckoutFinishButton()
                .clickBackToProductsButton();
    }

    @Test(groups = {"smoke"})
    public void verifyOrderCompletionMessage() {
        String expectedMessage = "THANK YOU FOR YOUR ORDER";
        String actualMessage = login()
                .getCart().clickCartIcon()
                .clickCheckoutButton()
                .fillCheckoutFirstName("John")
                .fillCheckoutLastName("Doe")
                .fillCheckoutPostalCode("12345")
                .clickCheckoutContinueButton()
                .clickCheckoutFinishButton()
                .getCheckoutCompleteHeading().textContent();
        assert actualMessage.contains(expectedMessage) : "Expected message: " + expectedMessage + ", but got: " + actualMessage;
    }

    @Test(groups = {"smoke"})
    public void verifyContinueShoppingButtonFunctionality() {
        login()
                .getCart().clickCartIcon()
                .clickCheckoutButton()
                .fillCheckoutFirstName("John")
                .fillCheckoutLastName("Doe")
                .fillCheckoutPostalCode("12345")
                .clickCheckoutContinueButton()
                .clickCheckoutFinishButton()
                .clickBackToProductsButton();
    }

    @Test(groups = {"smoke"})
    public void verifyOrderCompletionPageElements() {
        var orderCompletionPage = login()
                .getCart().clickCartIcon()
                .clickCheckoutButton()
                .fillCheckoutFirstName("John")
                .fillCheckoutLastName("Doe")
                .fillCheckoutPostalCode("12345")
                .clickCheckoutContinueButton()
                .clickCheckoutFinishButton();
        assert orderCompletionPage.getCheckoutCompleteHeading().isVisible() : "Checkout complete heading is not visible";
    }

    @Test(groups = {"smoke"})
    public void verifyOrderCompletionPageUrl() {
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        String actualUrl = login()
                .getCart().clickCartIcon()
                .clickCheckoutButton()
                .fillCheckoutFirstName("John")
                .fillCheckoutLastName("Doe")
                .fillCheckoutPostalCode("12345")
                .clickCheckoutContinueButton()
                .clickCheckoutFinishButton()
                .getUrl();
        assert actualUrl.equals(expectedUrl) : "Expected URL: " + expectedUrl + ", but got: " + actualUrl;
    }
}
