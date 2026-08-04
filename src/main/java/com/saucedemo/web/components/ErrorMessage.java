package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class ErrorMessage extends BaseComponent{
    public ErrorMessage(Locator element){
        super(element);
    }
    public Locator isVisible() {
        return element.locator("div.error-message-container").locator("[data-test='error']");
    }

    public Locator getText() {
        return element.locator("div.error-message-container").locator("[data-test='error']");
    }

    public Locator getCloseButton() {
        return element.locator("div.error-message-container").locator("[data-test='error'] button");
    }

    public void close() {
        getCloseButton().click();
    }

    public boolean isErrorMessageVisible() {
        return isVisible().count() > 0;
    }

    public String getErrorMessageText() {
        return getText().innerText();
    }

}
