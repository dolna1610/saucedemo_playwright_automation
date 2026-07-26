package com.saucedemo.web.utils;

import com.microsoft.playwright.options.ScreenSize;
import com.microsoft.playwright.options.ViewportSize;
import lombok.Getter;

public enum Device {
    DESKTOP(1280, 800),
    MOBILE(375, 600, true),
    TAB(767, 1024, true, 1, "Mozilla/5.0 (Linux; Android 4.0.3; GT-N7000 Build/IML74K) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19"),
    IPHONE_13(390, 844, true, 3, "Mozilla/7.0 (iPhone; CPU iPhone OS 17_1; iPhone 13) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1"),
    IPAD_AIR(820, 1180, true, 2, "Mozilla/5.0 (iPad; CPU OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1");

    private final int width;
    private final int height;
    @Getter
    private final boolean mobile;
    @Getter
    private final double dpi;
    @Getter
    private final String userAgent;

    Device(int width, int height) {
        this(width, height, false, 1, null);
    }

    Device(int width, int height, boolean mobile) {
        this(width, height, mobile, 1, null);
    }

    Device(int width, int height, boolean mobile, double dpi, String userAgent) {
        this.width = width;
        this.height = height;
        this.mobile = mobile;
        this.dpi = dpi;
        this.userAgent = userAgent;
    }

    public ViewportSize getViewportSize() {
        return new ViewportSize(width, height);
    }

    public ScreenSize getScreenSize() {
        return new ScreenSize(width, height);
    }
}
