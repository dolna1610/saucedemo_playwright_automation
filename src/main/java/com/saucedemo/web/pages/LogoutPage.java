package com.saucedemo.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LogoutPage extends BasePage{
    public LogoutPage(Page page){
        super(page);
    }

    @Override
    public String getPageId(){
        return "";
    }

    @Override
    public String getUrl(){
        return "/logout.html";
    }

    public LoginPage clickLogoutButton() {
        page.locator("[data-test='logout']").click();
        return new LoginPage(page);
    }

    public LoginPage clickLoginButton() {
        page.locator("[data-test='login']").click();
        return new LoginPage(page);
    }

    public Locator getLogoutHeading() {
        return page.locator(".title");
    }
}
