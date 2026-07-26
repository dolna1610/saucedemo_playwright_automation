package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class Trip extends BaseComponent {
    final String formAirportSelector = "[data-testid^='departure-airport-input-form-']";
    final String toAirportSelector = "[data-testid^='destination-airport-input-form-']";

    public Trip(Locator element) {
        super(element);
    }

    public Trip clickFromAirport() {
        element.locator(formAirportSelector).first().click();
        return this;
    }

    public Trip fillFromAirport(String fromAirport) {
        element.locator(formAirportSelector).first().fill(fromAirport);
        return this;
    }

    public Trip selectFromAirport(String fromAirport) {
        if (isMobile()) {
            getPage().locator(".drawer").getByText(fromAirport).first().click();
        } else {
            element.getByText(fromAirport).first().click();
        }
        return this;
    }

    public Trip clickToAirport() {
        element.locator(toAirportSelector).last().click();
        return this;
    }

    public Trip fillToAirport(String fromAirport) {
        element.locator(toAirportSelector).last().fill(fromAirport);
        return this;
    }

    public Trip selectToAirport(String toAirport) {
        if (isMobile()) {
            getPage().locator(".drawer").getByText(toAirport).first().click();
        } else {
            element.getByText(toAirport).first().click();
        }
        return this;
    }

    public Locator getErrorMessageLocator() {
        return element.locator(".bg-brand-1.text-center.text-xs.text-brand-3");
    }
}
