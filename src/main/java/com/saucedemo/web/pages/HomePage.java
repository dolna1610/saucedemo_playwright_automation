package com.saucedemo.web.pages;

import com.microsoft.playwright.Locator;
import com.saucedemo.web.components.SearchFormNavigationBar;
import com.saucedemo.web.components.Slider;
import com.microsoft.playwright.Page;
import com.saucedemo.web.components.Topbar;

public class HomePage extends BasePage {
    public HomePage(Page page) {
        super(page);
    }

    public String getPageId() {
        return "";
    }

    public String getUrl() {
        return "https://www.saucedemo.com/";
    }

    public Locator getTitle() {
        return page.getByText("Swag Labs", new Page.GetByTextOptions().setExact(true));
    }

    public SearchFormNavigationBar getSearchFormNavigationBar() {
        return new SearchFormNavigationBar(page.locator("div.z-20.top-0"));
    }

    public Topbar getTopbar() {
        return new Topbar(page.locator("body"));
    }

    public Slider getOffers() {
        return new Slider(page.locator(".flex.h-fit.justify-center"));
    }

}
