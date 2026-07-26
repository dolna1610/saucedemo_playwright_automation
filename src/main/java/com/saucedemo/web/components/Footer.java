package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class Footer extends BaseComponent {
    
    public Footer(Locator element) {
        super(element);
    }

    public Locator getFacebookIconLocator() {
        return element.locator("[href='https://www.facebook.com/firsttripbd/']").first();
    }

    public Locator getTwitterIconLocator() {
        return element.locator("[href='https://x.com/']").first();
    }

    public Locator getInstagramIconLocator() {
        return element.locator("[href='https://www.instagram.com/firsttripstories/']").first();
    }

    public Locator getLinkedinIconLocator() {
        return element.locator("[href='https://www.linkedin.com/company/first-trip-limited/']").first();
    }

    public Locator getYouTubeIconLocator() {
        return element.locator("[href='https://www.youtube.com/@FirstTripbd']").first();
    }
}
