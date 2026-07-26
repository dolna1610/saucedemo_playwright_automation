package com.saucedemo.web.enums;

import lombok.Getter;

@Getter
public enum PaymentMethod {
    B_KASH(0, "bKash"),
    NAGAD(1, "Nagad"),
    VISA(2, "Debit/Credit"),
    ROCKET(3, "Rocket");

    private final int value;
    private final String name;

    PaymentMethod(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
