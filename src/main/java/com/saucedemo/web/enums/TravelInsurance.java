package com.saucedemo.web.enums;

import lombok.Getter;

@Getter
public enum TravelInsurance {
    I_DO_NOT_NEED_INSURANCE("I do not need insurance"),
    DOMESTIC("Domestic"),
    SILVER("Silver"),
    GOLD("Gold");

    private final String value;

    TravelInsurance(String value) {
        this.value = value;
    }
}
