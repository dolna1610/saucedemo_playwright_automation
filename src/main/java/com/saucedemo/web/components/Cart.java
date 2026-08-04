package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;
import com.saucedemo.web.pages.CartPage;

public class Cart extends BaseComponent{
    public Cart(Locator element) {
        super(element);
    }

    public Locator getCartIcon() {
        return element;
    }

    public Locator getCartBadge() {
        return element.locator(".shopping_cart_badge");
    }

    public Locator getCartItem(String itemName) {
       return element.locator(".shopping-cart-link");
    }

    public CartPage clickCartIcon() {
        getCartIcon().click();
        return new CartPage(element.page());
    }

    public Locator getCartBadgeCount() {
        return getCartBadge();
    }

    public Locator getCartItemRemoveButton(String itemName) {
        return getCartItem(itemName).locator("button").getByText("Remove");
    }

    public Locator getCartItemName(String itemName) {
        return getCartItem(itemName).locator(".inventory_item_name");
    }

    public Locator getCartItemDescription(String itemName) {
        return getCartItem(itemName).locator(".inventory_item_desc");
    }

    public Locator getCartItemPrice(String itemName) {
        return getCartItem(itemName).locator(".inventory_item_price");
    }

    public Locator getCartItemQuantity(String itemName) {
        return getCartItem(itemName).locator(".cart_quantity");
    }

    public Locator getCartItemImage(String itemName) {
        return getCartItem(itemName).locator(".inventory_item_img");
    }

    public Locator getCheckedInLocator() {
        return element.getByText("Checked-in");
    }
}
