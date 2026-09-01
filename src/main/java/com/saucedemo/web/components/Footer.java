package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class Footer extends BaseComponent {

    public Footer(Locator element) {
        super(element);
    }

    public Locator getFacebookIconLocator() {
        return element.locator("[href='https://www.facebook.com/saucelabs']").first();
    }

    public Locator getTwitterIconLocator() {
        return element.locator("[href='https://twitter.com/saucelabs']").first();
    }

    public Locator getLinkedinIconLocator() {
        return element.locator("[href='https://www.linkedin.com/company/sauce-labs/']").first();
    }
}
