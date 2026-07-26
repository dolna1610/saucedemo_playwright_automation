package com.saucedemo.web.enums;

import lombok.Getter;

@Getter
public enum WheelChair {
    WHEELCHAIR_SHORT_DISTANCE_STAIRS("Wheelchair assistance required; passenger can walk short distance up or down stairs."),
    WHEELCHAIR_SHORT_DISTANCE_NO_STAIRS("Wheelchair assistance required; passenger can walk short distance, but not up or down stairs."),
    WHEELCHAIR_AISLE_CHAIR("Wheelchair required; passenger cannot walk any distance and will require the aisle chair to board."),
    ONBOARD_AISLE_WHEELCHAIR("On-board aisle wheelchair requested (for use during flight)."),
    MANUAL_WHEELCHAIR("Passenger is traveling with a manual wheelchair."),
    DRY_CELL_BATTERY_POWERED_WHEELCHAIR("Passenger is traveling with a dry cell battery-powered wheelchair."),
    WET_CELL_BATTERY_POWERED_WHEELCHAIR("Passenger is traveling with a wet cell battery-powered wheelchair.");

    private final String value;

    WheelChair(String value) {
        this.value = value;
    }
}
