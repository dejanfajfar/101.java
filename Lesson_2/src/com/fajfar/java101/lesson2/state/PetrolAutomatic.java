package com.fajfar.java101.lesson2.state;

public class PetrolAutomatic extends Car{

    protected PetrolAutomatic() {
        super("Petrol", 10.3, true);
    }

    @Override
    public int shiftUp() {
        return 0;
    }

    @Override
    public int shiftDown() {
        return 0;
    }
}
