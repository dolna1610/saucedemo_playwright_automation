package com.saucedemo.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.saucedemo.web.components.ProductInfo;
import com.saucedemo.web.components.SelectElement;

import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(Page page){
        super(page);
    }
    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getUrl() {
        return "/inventory.html";
    }

    public Locator getProductsHeading(){
        return page.getByText("Products");
    }

    public List<ProductInfo> getProductDetails(){
        return page.locator(".inventory_item")
                .all().stream()
                .map(ProductInfo::new)
                .toList();
    }

    public Locator getProductCards() {
        return page.locator(".inventory_item");
    }

    public Locator getSortDropdown() {
        return page.locator("[data-test='product-sort-container']");
    }

    public ProductPage selectSortOption(String value) {
        getSortDropdown().selectOption(value);
        return this;
    }

    public List<String> getAllProductNames() {
        return page.locator(".inventory_item_name")
                .allTextContents();
    }

    public CartPage clickCartIcon() {
        page.locator("[data-test='shopping-cart-link']").click();
        return new CartPage(page);
    }

    public ProductPage addSingleProductToCart() {
        page.locator("[data-test='add-to-cart-sauce-labs-backpack']").click();
        return this;
    }

    public void addMultipleProductsToCart() {
        page.locator("[data-test='add-to-cart-sauce-labs-backpack']").click();
        page.locator("[data-test='add-to-cart-sauce-labs-bike-light']").click();
    }

    public Locator getCartBadge() {
        return  page.locator("[data-test='shopping-cart-badge']");
    }

    public void removeProductFromCart() {
        page.locator("[data-test='add-to-cart-sauce-labs-backpack']").click();
        page.locator("[data-test='remove-sauce-labs-backpack']").click();
    }
}
