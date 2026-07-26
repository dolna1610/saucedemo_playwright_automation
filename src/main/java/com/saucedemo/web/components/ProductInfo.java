package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class ProductInfo extends BaseComponent {
    final String AMOUNT_LOCATOR = ".col-span-1.text-end.text-brand-8";

    public ProductInfo(Locator element) {
        super(element);
    }

    public Locator getProductImage(){
        return element.locator(".inventory_item_img img");
    }

    public Locator getProductName(){
        return element.locator(".inventory_item_name");
    }

    public Locator getProductDescription(){
        return element.locator(".inventory_item_desc");
    }

    public Locator getProductPrice(){
        return element.locator(".inventory_item_price");
    }

    public Locator getAddToCartButton(){
        return element.locator("button[data-test^='add-to-cart']");
    }
}
