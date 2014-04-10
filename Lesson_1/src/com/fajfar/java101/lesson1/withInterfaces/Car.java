package com.fajfar.java101.lesson1.withInterfaces;

import static java.lang.Math.abs;

public class Car {
    public static final String ENGINE_NULL = "The provided engine can not be null";
    public static final String TRANSMISSION_NULL = "The provided transmission can not be null";
    public static final String DECELERATE_NEGATIVE = "The deceleration delta can not be a negative number";

    private String brand;
    private String model;
    private int currentSpeed;
    private Engine engine;
    private Transmission transmission;

    public Car(String brand, String model, Engine engine, Transmission transmission){
        setBrand(brand);
        setModel(model);
        setEngine(engine);
        setTransmission(transmission);
        currentSpeed = 0;
    }

    public String getCarMake(){
        return String.format("%1$s-%2$s", this.brand, this.model);
    }

    public void startTheEngine(){
        this.engine.turnOn();
    }

    public void stopTheEngine(){
        this.engine.turnOff();
    }

    public int getCurrentSpeed(){
        return this.currentSpeed;
    }

    public int accelerate(int deltaSpeed){
        if(deltaSpeed < 0){
            decelerate(abs(deltaSpeed));
        }
        return changeSpeed(deltaSpeed);
    }

    public int decelerate(int deltaSpeed){
        if(deltaSpeed < 0){
            throw new IllegalArgumentException(DECELERATE_NEGATIVE);
        }
        return changeSpeed(deltaSpeed * -1);
    }

    private int changeSpeed(int deltaSpeed){
        if(!this.engine.isRunning()){
            return this.currentSpeed;
        }

        else if(deltaSpeed < 0 && abs(deltaSpeed) > this.currentSpeed){
            this.engine.idle();
            this.currentSpeed = 0;
        }
        int newSpeed = this.currentSpeed + deltaSpeed;

        int neededRpm = this.transmission.calculateRpm(newSpeed);

        if(!this.engine.canHandleRpm(neededRpm)){
            int engineRpm = this.engine.goFlatOut();
            this.currentSpeed = this.transmission.calculateSpeed(engineRpm);
            return this.currentSpeed;
        }

        this.engine.setRpm(neededRpm);
        this.currentSpeed = newSpeed;

        return this.currentSpeed;
    }

    private void setBrand(String brand){
        if(brand == null && brand.isEmpty()){
            return;
        }

        this.brand = brand;
    }

    private void setModel(String model){
        if(model == null && model.isEmpty()){
            return;
        }

        this.model = model;
    }

    private void setEngine(Engine engine){
        if(engine == null){
            throw new IllegalArgumentException(ENGINE_NULL);
        }

        this.engine = engine;
    }

    private void setTransmission(Transmission transmission){
        if(transmission == null){
            throw new IllegalArgumentException(TRANSMISSION_NULL);
        }

        this.transmission = transmission;
    }
}
