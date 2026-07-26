package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public abstract class BaseComponent {
    protected Locator element;

    public BaseComponent(Locator element) {
        this.element = element;
    }

    public boolean isMobile() {
        return getPage().viewportSize().width < 768;
    }

    protected Page getPage() {
        return element.page();
    }

    protected Locator getDrawerLocator(){
        return getPage().locator(".drawer");
    }
}
