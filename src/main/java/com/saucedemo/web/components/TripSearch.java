package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class TripSearch extends BaseComponent {

    public TripSearch(Locator element) {
        super(element);
    }

    public Locator getFromAirportLocator() {
        return element.locator("div.col-span-1 .text-brand-7.lg\\:text-start").first();
    }

    public Locator getToAirportLocator() {
        return element.locator("div.relative.col-span-1 .text-brand-7.md\\:truncate").first();
    }

    public Locator getDateLocator() {
        return element.locator("div.col-span-1 .text-brand-7").first();
    }

    public Locator getDepartureTimeLocator() {
        return element.locator("div.col-span-1 .text-brand-8.lg\\:text-start").first();
    }

    public Locator getArrivalTimeLocator() {
        return element.locator("div.relative.col-span-1 .text-brand-8").first();
    }

    public Locator getStayTimeLocator() {
        return element.locator(".col-span-1 .font-semibold.text-brand-8").nth(1);
    }
}
