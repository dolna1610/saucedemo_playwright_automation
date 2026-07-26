package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class SearchFormNavigationBar extends BaseComponent {
    public SearchFormNavigationBar(Locator element) {
        super(element);
    }

    public void clickFlight() {
        element.getByTestId("search-form-tab-Flight").click();
    }

    public void clickHoliday() {
        element.getByTestId("search-form-tab-Holiday").click();
    }

    public void clickStays() {
        element.getByTestId("search-form-tab-Stays").click();
    }

    public void clickVisa() {
        element.getByTestId("search-form-tab-Visa").click();
    }

    public void clickUmrah() {
        element.getByTestId("search-form-tab-Umrah").click();
    }
}
