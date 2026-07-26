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

    public Locator getPasswordField() {
        return element.locator("#password");
    }

    public void clickSignOut() {
        element.locator(".flex .w-full.border-brand-tint.first\\:border-none").nth(2).click();
    }

    public void clickNotificationIcon() {
        element.getByTestId("view-notification").locator(".cursor-pointer > img").first().click();
    }

    public Locator getNotificationDropdownLocator() {
        return element.getByTestId("view-notification").locator("> div.shadow-lg");
    }
}
