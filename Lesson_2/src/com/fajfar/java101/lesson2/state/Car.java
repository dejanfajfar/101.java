package com.fajfar.java101.lesson2.state;

public abstract class Car {

    protected Car(String fuelType, double fuelConsumption, boolean isAutomatic){
        this.fuelConsumption = fuelConsumption;
        this.fuelType = fuelType;
        this.isAutomatic = isAutomatic;
    }

    private String fuelType;
    private double fuelConsumption;
    private boolean isAutomatic;

    public double getFuelConsumption(){
        return this.fuelConsumption;
    }

    public String getFuelType(){
        return this.fuelType;
    }

    public boolean isAutomatic(){
        return this.isAutomatic;
    }

    public abstract int shiftUp();
    public abstract int shiftDown();
}
