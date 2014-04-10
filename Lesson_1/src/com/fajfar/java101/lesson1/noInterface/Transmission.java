package com.fajfar.java101.lesson1.noInterface;

public class Transmission {
    public Transmission(){}

    public int calculateSpeed(int rpm){
        return rpm / 100;
    }

    public int calculateRpm(int speed){
        return speed * 100;
    }
}
