package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public abstract class DatePicker extends BaseComponent {
    public DatePicker(Locator element) {
        super(element);
    }

    public Locator dateLocator = this.element;

    public abstract String currentDateSelector();

    public abstract String dateSelector(String date);

    public abstract String dateRangeSelector(Range range);

    public abstract String nextMonthSelector();

    public abstract String prevMonthSelector();

    public abstract String selectedDateSelector();

    public boolean hasRange() {
        return this.element.locator(dateRangeSelector(Range.FIRST)).first().isVisible()
                && this.element.locator(dateRangeSelector(Range.SECOND)).first().isVisible();
    }

    public void selectDate(String date) {
        if (!dateLocator.locator(dateSelector(date)).last().isVisible()) {
            dateLocator.locator(dateSelector(date)).first().click();
        } else {
            dateLocator.locator(dateSelector(date)).last().click();
        }
    }

    public DatePicker selectRange(Range range) {
        dateLocator = this.element.locator(dateRangeSelector(range));
        return this;
    }

    public void clickCurrentDate() {
        if (!dateLocator.locator(dateSelector(getCurrentDate())).first().isVisible()) {
            dateLocator.locator(dateSelector(clickPrevious().getCurrentDate())).first().click();
        } else {
            dateLocator.locator(dateSelector(getCurrentDate())).first().click();
        }
    }

    public DatePicker clickNextMonth() {
        Locator next = this.element.locator(nextMonthSelector());
        if (next.first().isVisible()) {
            next.click();
        }
        return this;
    }

    public boolean hasPreviousButton() {
        return this.element.locator(prevMonthSelector()).first().isVisible();
    }

    public DatePicker clickPrevious() {
        Locator next = this.element.locator(prevMonthSelector());
        if (next.first().isVisible()) {
            next.click();
        }
        return this;
    }

    public String getSelectedDate() {
        String divText = this.element.locator(selectedDateSelector()).first().textContent();
        return divText.replaceAll("\\D+", "");
    }

    public String getCurrentDate() {
        if (!this.element.locator(currentDateSelector()).first().isVisible()) {
            return this.element.locator(clickPrevious().currentDateSelector()).first().textContent();
        } else {
            return this.element.locator(currentDateSelector()).first().textContent();
        }
    }

    public enum Range {
        FIRST,
        SECOND
    }
}
