package com.saucedemo.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private static final String PAGE_ID = "login-page";

    public LoginPage(Page page) {
        super(page);
    }

    @Override
    public String getPageId() {
        return PAGE_ID;
    }

    @Override
    public String getUrl() {
        return "";
    }

    public LoginPage fillUserName(String Name) {
        Locator userNameField = page.locator("#user-name");
        userNameField.fill(Name);
        return this;
    }

    public LoginPage fillPassword(String password) {
        Locator passwordField = page.locator("#password");
        passwordField.fill(password);
        return this;
    }

    public LoginPage clickLogin() {
        page.locator("#login-button").click();
        return this;
    }

    public LoginPage clickMenuBar(){
        page.locator("#react-burger-menu-btn").first().click();
        return this;
    }

    public LoginPage clickLogoutButton(){
        page.locator("#logout_sidebar_link").first().click();
        return this;
    }

    public Locator getLoginButtonLocator() {
        return page.locator("#login-button");
    }

    public LoginPage waitForPageLoad() {
        page.waitForSelector("#login-button");
        return this;
    }
}
