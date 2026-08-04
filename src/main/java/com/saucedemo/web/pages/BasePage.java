package com.saucedemo.web.pages;

import com.saucedemo.web.components.*;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Objects;

public abstract class BasePage {
    protected final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public abstract String getPageId();

    public abstract String getUrl();

    public String currentPageId() {
        return page.locator("body").getAttribute("data-test-id");
    }

    public boolean isPage(String pageId) {
        return Objects.equals(pageId, currentPageId());
    }

    public boolean isAtPage() {
        return isPage(getPageId());
    }

    public String getPageTitle() {
        return page.title();
    }

    public Topbar getTopbar() {
        return new Topbar(page.getByText("Products"));
    }

    public ErrorMessage getError(){
        return new ErrorMessage(page.locator("[data-test='error']"));
    }

    public Footer getFooter() {
        return new Footer(page.locator("#footer"));
    }

    public boolean isMobile() {
        return page.viewportSize().width < 768;
    }

    public Cart getCart() {
        return new Cart(page.locator(".shopping_cart_link"));
    }
}
