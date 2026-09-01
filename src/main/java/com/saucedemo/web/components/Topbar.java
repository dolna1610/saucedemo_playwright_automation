package com.saucedemo.web.components;

import com.saucedemo.web.pages.LoginPage;
import com.microsoft.playwright.Locator;

public class Topbar extends BaseComponent {
    public Topbar(Locator element) {
        super(element);
    }

    public LoginPage getHeading() {
        element.getByText("Swag Labs").nth(2).isVisible();
        return new LoginPage(element.page());
    }

    public Locator getProductsLocator() {
        return element.getByText("Products").first();
    }

    public Topbar clickProfileDropdownButton() {
        getProductsLocator().click();
        return this;
    }
    public Topbar fillUserName(String name) {
        element.locator("#user-name").fill(name);
        return this;
    }

    public Topbar fillPassword(String password) {
        element.locator("#password").fill(password);
        return this;
    }

    public Topbar clickLogin() {
        element.locator("#login-button").click();
        return this;
    }

    public Locator getErrorMessage() {
        return element.locator("[data-test='error']");
    }

    public Locator getLoginButton() {
        return element.locator("#login-button");
    }

    public Locator getNotificationDropdownLocator() {
        return element.getByTestId("view-notification").locator("> div.shadow-lg");
    }
}
