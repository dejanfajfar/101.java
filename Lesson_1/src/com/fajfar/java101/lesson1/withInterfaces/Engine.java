package com.fajfar.java101.lesson1.withInterfaces;

public interface Engine {
    String ILLEGAL_VOLUME = "Engine volume may not be 0 ccm or less";
    String ILLEGAL_POWER = "Engine power may not be 0 hp or less";
    String ILLEGAL_FUEL_TYPE = "Fuel type can not be null";

    void turnOn();

    void turnOff();

    int getRpm();

    int idle();

    boolean isRunning();

    boolean canHandleRpm(int rpm);

    int goFlatOut();

    int setRpm(int desiredRpm);
}
