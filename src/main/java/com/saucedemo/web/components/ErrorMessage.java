package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class ErrorMessage extends BaseComponent{
    public ErrorMessage(Locator element){
        super(element);
    }

    /*public LoginPage getErrorMessage() {
        element.getByText("Epic sadface: Username and password do not match any user in this service").isVisible();
        return new LoginPage(element.page());
    }*/
    public Locator isVisible() {
        return element.locator("div.error-message-container").locator("[data-test='error']");
    }

    public Locator getText() {
        return element.locator("div.error-message-container").locator("[data-test='error']");
    }

    /*public Locator getProductsLocator() {
        return element.getByText("Products").first();
    }*/
}
