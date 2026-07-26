package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class SelectElement extends BaseInputElement {
    public SelectElement(Locator element) {
        super(element);
    }

    public SelectElement clickSelect() {
        element.click();
        return this;
    }

    public String getOptionText() {
        return element.textContent();
    }

    public void selectOption(String optionName) {
        getSelectMenu().locator("text='" + optionName + "'").click();
    }

    private Locator getSelectMenu() {
        return element.locator("div[data-overlayscrollbars-contents]");
    }

    /*public SortElement getSortDropdown() {
        return new SortElement(element.locator("[data-test='product-sort-container']"));
    }*/
}
