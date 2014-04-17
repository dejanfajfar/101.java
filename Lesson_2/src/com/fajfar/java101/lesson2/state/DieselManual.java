package com.fajfar.java101.lesson2.state;

public class DieselManual extends Car {

    private int currentGear;
    private final int maxGear;

    public DieselManual() {
        super("Diesel", 5.7, false);
        this.maxGear = 6;
        this.currentGear = 0;
    }


    @Override
    public int shiftUp() {
        this.currentGear = ++this.currentGear % this.maxGear;
        return currentGear;
    }

    @Override
    public int shiftDown() {
        if(this.currentGear >= 1){
            this.currentGear--;
        }
        return this.currentGear;
    }
}
