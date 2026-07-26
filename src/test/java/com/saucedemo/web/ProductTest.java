package com.saucedemo.web;

import com.microsoft.playwright.options.LoadState;
import com.saucedemo.web.components.ProductInfo;
import com.saucedemo.web.pages.ProductPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class ProductTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void verifyProductPageLoadAfterLogin() {

        ProductPage productPage = login();
        assertThat(productPage.getProductsHeading()).hasText("Products");
        this.page.waitForLoadState(LoadState.NETWORKIDLE);

        ProductInfo productInfo = productPage.getProductDetails().getFirst();

        assertThat(productInfo.getProductImage().first()).isVisible();
        assertThat(productInfo.getProductName()).hasText("Sauce Labs Backpack");
        assertThat(productInfo.getProductDescription()).isVisible();
        assertThat(productInfo.getProductPrice()).isVisible();
        assertThat(productInfo.getAddToCartButton()).isVisible();
    }

    @Test
    public void verifyAllProductsAreVisible() {
        ProductPage productPage = login();

        assertThat(productPage.getProductsHeading()).hasText("Products");

        assertThat(productPage.getProductCards()).hasCount(6);

        for (ProductInfo product : productPage.getProductDetails()) {

            assertThat(product.getProductImage()).isVisible();
            assertThat(product.getProductName()).isVisible();
            assertThat(product.getProductDescription()).isVisible();
            assertThat(product.getProductPrice()).isVisible();
            assertThat(product.getAddToCartButton()).isVisible();
        }
    }

    @Test
    public void verifyProductSorting_A_To_Z() {
        ProductPage productPage = login();
        productPage.selectSortOption("az");
        List<ProductInfo> products = productPage.getProductDetails();
        assertThat(products.getFirst().getProductName()).hasText("Sauce Labs Backpack");
        assertThat(products.getLast().getProductName()).hasText("Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void verifyProductSorting_Price_Low_To_High() {
        ProductPage productPage = login();
        productPage.selectSortOption("lohi");

        List<ProductInfo> products = productPage.getProductDetails();
        assertThat(products.getFirst().getProductName()).hasText("Sauce Labs Onesie");
        assertThat(products.getFirst().getProductPrice()).hasText("$7.99");
        assertThat(products.getLast().getProductName()).hasText("Sauce Labs Fleece Jacket");
        assertThat(products.getLast().getProductPrice()).hasText("$49.99");
    }

    @Test
    public void verifyProductSorting_Price_High_To_Low() {
        ProductPage productPage = login();
        productPage.selectSortOption("hilo");

        List<ProductInfo> products = productPage.getProductDetails();
        assertThat(products.getLast().getProductName()).hasText("Sauce Labs Onesie");
        assertThat(products.getLast().getProductPrice()).hasText("$7.99");
        assertThat(products.getFirst().getProductName()).hasText("Sauce Labs Fleece Jacket");
        assertThat(products.getFirst().getProductPrice()).hasText("$49.99");
    }

    @Test
    public void verifyProductSorting_Z_To_A() {
        ProductPage productPage = login();
        productPage.selectSortOption("za");

        List<ProductInfo> products = productPage.getProductDetails();
        assertThat(products.getFirst().getProductName()).hasText("Test.allTheThings() T-Shirt (Red)");
        assertThat(products.getLast().getProductName()).hasText("Sauce Labs Backpack");
    }

    @Test
    public void verifyProductDetails() {
        ProductPage productPage = login();
        assertThat(productPage.getProductsHeading()).hasText("Products");

        List<ProductInfo> products = productPage.getProductDetails();
        assertThat(productPage.getProductCards()).hasCount(6);

        for (ProductInfo product : products) {
            assertThat(product.getProductName()).isVisible();
            assertThat(product.getProductPrice()).isVisible();
            assertThat(product.getProductDescription()).isVisible();
        }
    }
}
