package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class BaseLargeInputElement extends BaseInputElement {
    public BaseLargeInputElement(Locator element) {
        super(element);
    }

    @Override
    public Boolean isRequired() {
        return element.locator("..").locator("p > span").first().count() > 0;
    }
}
