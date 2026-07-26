package com.saucedemo.web.pages;

import com.saucedemo.web.components.TextInputElement;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PaymentSandboxPage extends BasePage {

    public PaymentSandboxPage(Page page) {
        super(page);
    }

    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getUrl() {
        return "";
    }

    public TextInputElement getBkashAccountNumberInput() {
        return new TextInputElement(page.locator(".input-numeric.form-input"));
    }

    public TextInputElement getBkashVerificationCodeInput() {
        return new TextInputElement(page.locator(".input-numeric.form-input"));
    }

    public TextInputElement getBkashPinInput() {
        return new TextInputElement(page.locator(".input-numeric.form-input"));
    }

    public Locator paymentSuccessTextLocator() {
        return page.locator(".text-2xl.font-medium.text-brand-8");
    }

    public ElementHandle paymentStatusLocator() {
        return page.waitForSelector(".flex.bg-brand-3.text-center.text-brand-7");
    }
}
