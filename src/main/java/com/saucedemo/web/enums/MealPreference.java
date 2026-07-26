package com.saucedemo.web.enums;

import lombok.Getter;

@Getter
public enum MealPreference {
    CHILD_MEAL("CHILD MEAL"),
    DIABETIC_MEAL("DIABETIC MEAL"),
    INFANT_BABY_FOOD("INFANT/BABY FOOD"),
    ASIAN_VEGETARIAN_MEAL("ASIAN VEGETARIAN MEAL"),
    MUSLIM_MEAL("MUSLIM MEAL");

    private final String value;

    MealPreference(String value) {
        this.value = value;
    }
}
