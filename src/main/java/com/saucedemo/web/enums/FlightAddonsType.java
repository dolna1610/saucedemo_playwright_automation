package com.saucedemo.web.enums;

import lombok.Getter;

@Getter
public enum FlightAddonsType {
    MEAL_PREFERENCE(0),
    WHEELCHAIR(1),
    TRAVEL_INSURANCE(2);

    private final int index;

    FlightAddonsType(int index) {
        this.index = index;
    }
}
