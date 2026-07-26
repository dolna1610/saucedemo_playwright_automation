package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

import java.util.List;

public class Slider extends BaseComponent {

    public Slider(Locator element) {
        super(element);
    }

    public List<Locator> getOffers() {
        return element.locator("a").all();
    }

    public void clickPreviousArrow() {
        element.getByTestId("prev-button").click();
    }

    public void clickNextArrow() {
        element.getByTestId("next-button").click();
    }
}
