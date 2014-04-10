package com.fajfar.java101.lesson1.withInterfaces.engines;

import com.fajfar.java101.lesson1.withInterfaces.Engine;
import com.fajfar.java101.lesson1.withInterfaces.FuelType;

public abstract class BaseEngine implements Engine {

    protected BaseEngine(int volume, int power, FuelType fuelType){

    }

    private int minRpm;
    private int maxRpm;

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public int getRpm() {
        return 0;
    }

    @Override
    public int idle() {
        return 0;
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean canHandleRpm(int rpm) {
        return false;
    }

    @Override
    public int goFlatOut() {
        return 0;
    }

    @Override
    public int setRpm(int desiredRpm) {
        return 0;
    }
}
