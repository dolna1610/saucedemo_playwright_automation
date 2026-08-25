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

    public Locator getCartHeading() {
        return page.locator(".title");
    }

    public Locator getContinueShoppingButton(){
        return page.locator("[data-test='continue-shopping']");
    }

    public Locator getCheckoutButton(){
        return page.locator("[data-test='checkout']");
    }

    public CheckoutPage clickCheckoutButton() {
        page.locator("[data-test='checkout']").click();
        return new CheckoutPage(page);
    }

    public Locator getCartTitleLocator() {
        return page.locator("[data-test='title']");
    }
}
