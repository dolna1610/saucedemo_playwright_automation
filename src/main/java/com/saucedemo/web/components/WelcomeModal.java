package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class WelcomeModal extends BaseComponent {
    public WelcomeModal(Locator element) {
        super(element);
    }

    public void close() {
        element.locator("button").click();
    }
}