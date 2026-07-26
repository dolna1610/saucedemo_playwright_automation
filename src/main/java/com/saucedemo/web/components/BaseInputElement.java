package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public abstract class BaseInputElement extends BaseComponent {

    public BaseInputElement(Locator element) {
        super(element);
    }

    public void fill(String value) {
        element.pressSequentially(value);
    }

    public Boolean hasError() {
        return element.locator("..").locator(".text-error").count() > 0;
    }

    public Boolean isRequired() {
        return element.locator("..").locator("..").locator("p > span").first().count() > 0;
    }
}
