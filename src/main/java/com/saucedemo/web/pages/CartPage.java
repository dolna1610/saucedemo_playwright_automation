package com.saucedemo.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage extends BasePage{

    public CartPage(Page page){
        super(page);
    }

    @Override
    public String getPageId(){
        return "";
    }

    @Override
    public String getUrl(){
        return "/cart.html";
    }

    public CartPage clickCartIcon() {
        page.locator("[data-test='shopping-cart-link']").click();
        return this;
    }

    public Locator getCartHeading() {
        return page.locator(".title");
    }
}
