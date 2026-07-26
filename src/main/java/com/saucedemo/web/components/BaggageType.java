package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class BaggageType extends BaseComponent{
    public BaggageType(Locator element) {
        super(element);
    }

    public Locator getCabinLocator() {
        return element.getByText("Cabin");
    }

    public Locator getCheckedInLocator() {
        return element.getByText("Checked-in");
    }
}
