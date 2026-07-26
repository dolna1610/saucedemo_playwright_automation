package com.saucedemo.web.pages;

import com.saucedemo.web.components.ErrorMessage;
import com.saucedemo.web.components.Footer;
import com.saucedemo.web.components.Topbar;
import com.saucedemo.web.components.WelcomeModal;
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

    protected Locator getDrawerLocator() {
        return page.locator(".drawer");
    }

    public boolean isMobile() {
        return page.viewportSize().width < 768;
    }

    public Locator getTripsLocator() {
        return page.locator(".flex-col.items-center.justify-center.px-3");
    }

    public Locator getWelcomeModalLocator() {
        return page.locator(".fixed.left-0.top-0.z-60");
    }

    public WelcomeModal getWelcomeModal() {
        return new WelcomeModal(getWelcomeModalLocator());
    }
}
