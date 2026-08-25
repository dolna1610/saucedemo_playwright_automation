package com.saucedemo.web;

import com.saucedemo.web.pages.CartPage;
import com.saucedemo.web.pages.ProductPage;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void verifyCartPageShouldOpenSuccessfully() {
        ProductPage productPage = login();
        CartPage cartPage = productPage.clickCartIcon();
        assertThat(page).hasURL(Pattern.compile(".*cart.html"));
        assertThat(cartPage.getCartHeading())
                .hasText("Your Cart");
    }

    @Test(groups = {"smoke"})
    public void verifyAddSingleProductToCart() {
        ProductPage productPage = login();
        productPage.addSingleProductToCart();
        assertThat(productPage.getCartBadge()).hasText("1");
    }

    @Test(groups = {"smoke"})
    public void verifyAddMultipleProductsToCart() {
        ProductPage productPage = login();

        productPage.addMultipleProductsToCart();

        assertThat(productPage.getCartBadge())
                .hasText("2");
    }

    @Test(groups = {"smoke"})
    public void verifyRemoveProductFromCart() {
        ProductPage productPage = login();

        productPage.removeProductFromCart();

        assertThat(productPage.getCartBadge())
                .not()
                .isVisible();
    }

    @Test(groups = {"smoke"})
    public void verifyCartIconCount() {
        ProductPage productPage = login();

        productPage.addMultipleProductsToCart();

        assertThat(productPage.getCartBadge())
                .hasText("2");
    }

    @Test(groups = {"smoke"})
    public void verifyCartPageNavigation() {
        ProductPage productPage = login();
        CartPage cartPage = productPage.clickCartIcon();

        assertThat(page).hasURL(Pattern.compile(".*cart.html"));
        assertThat(cartPage.getCartHeading()).hasText("Your Cart");
    }

    @Test(groups = {"smoke"})
    public void verifyCartPageLoadsSuccessfully() {
        ProductPage productPage = login();
        CartPage cartPage = productPage.clickCartIcon();

        assertThat(page).hasURL(Pattern.compile(".*cart.html"));
        assertThat(cartPage.getCartHeading()).hasText("Your Cart");
    }

    @Test(groups = {"smoke"})
    public void verifyAddedItemsAreVisibleInCart() {
        ProductPage productPage = login();
        productPage.addMultipleProductsToCart();
        CartPage cartPage = productPage.clickCartIcon();
        assertThat(cartPage.getCartHeading()).hasText("Your Cart");
    }

    @Test(groups = {"smoke"})
    public void verifyContinueShoppingButtonIsDisplayed() {
        ProductPage productPage = login();
        CartPage cartPage = productPage.clickCartIcon();

        assertThat(cartPage.getContinueShoppingButton()).isVisible();
        assertThat(cartPage.getCartHeading()).hasText("Your Cart");
        assertThat(cartPage.getContinueShoppingButton()).hasText("Continue Shopping");
    }

    @Test(groups = {"smoke"})
    public void verifyCheckoutButtonIsDisplayed() {
        ProductPage productPage = login();
        CartPage cartPage = productPage.clickCartIcon();

        assertThat(cartPage.getCartHeading()).hasText("Your Cart");
        assertThat(cartPage.getContinueShoppingButton()).isVisible();
        assertThat(cartPage.getCheckoutButton()).isVisible();
        assertThat(cartPage.getCheckoutButton()).hasText("Checkout");
    }
}

