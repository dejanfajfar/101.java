package com.fajfar.java101.lesson1.withInterfaces.engines;

import com.fajfar.java101.lesson1.withInterfaces.Engine;
import com.fajfar.java101.lesson1.withInterfaces.FuelType;

public abstract class BaseEngine implements Engine {

    protected BaseEngine(int volume, int power, FuelType fuelType){

    }

    private int minRpm;
    private int maxRpm;

    protected void setMinRpm(int minRpm){
        this.minRpm = minRpm;
    }

    protected void setMaxRpm(int maxRpm){
        this.maxRpm = maxRpm;
    }

    @Override
    public void turnOn() {
        if(!isRunning()){
            doTurnOn();
        }
    }

    protected abstract void doTurnOn();

    @Override
    public void turnOff() {
        if(isRunning()){
            doTurnOff();
        }
    }

    protected abstract void doTurnOff();

    @Override
    public int getRpm() {
        if(isRunning()){
            return doGetRpm();
        }
        return 0;
    }

    protected abstract int doGetRpm();

    @Override
    public int idle() {
        if(isRunning()){
            setRpm(this.minRpm);
        }
        return getRpm();
    }

    @Override
    public boolean isRunning() {
        return doCheckIsRunning();
    }

    protected abstract boolean doCheckIsRunning();

    @Override
    public boolean canHandleRpm(int rpm) {
        return doCanHandleRpm(rpm);
    }

    protected abstract boolean doCanHandleRpm(int rpm);

    @Override
    public int goFlatOut() {
        return 0;
    }

    @Override
    public int setRpm(int desiredRpm) {
        return 0;
    }
}
