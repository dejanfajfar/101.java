package com.fajfar.java101.lesson2.state;

public class CarController {
    private Car currentCar;

    protected CarController(Car currentCar){
        this.currentCar = currentCar;
    }

    public static CarController getDieselManual(){
        return new CarController(new DieselManual());
    }

    public static CarController getPetrolAutomatic(){
        return new CarController(new PetrolAutomatic());
    }

    public double getFuelConsumption(){
        return this.currentCar.getFuelConsumption();
    }

    public String getFuelType(){
        return this.currentCar.getFuelType();
    }

    public boolean isAutomatic(){
        return this.currentCar.isAutomatic();
    }

    public int shiftUp(){
        return this.currentCar.shiftUp();
    }

    public  int shiftDown(){
        return this.currentCar.shiftDown();
    }
}
