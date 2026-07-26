package com.saucedemo.web.enums;

import lombok.Getter;

@Getter
public enum CourtesyTitle {
    MR("Mr."),
    MRS("Mrs."),
    MS("Ms.");

    private final String value;

    CourtesyTitle(String value) {
        this.value = value;
    }
}
