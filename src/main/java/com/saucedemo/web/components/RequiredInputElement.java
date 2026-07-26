package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class RequiredInputElement extends BaseInputElement {
    public RequiredInputElement(Locator element) {
        super(element);
    }

    @Override
    public Boolean isRequired() {
        return element.locator("..").locator("-mt-2 text-sm font-bold").first().count() > 0;
    }
}

