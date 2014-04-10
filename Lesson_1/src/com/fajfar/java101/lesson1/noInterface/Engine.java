package com.fajfar.java101.lesson1.noInterface;

public class Engine {

    public static final String ILLEGAL_VOLUME = "Engine volume may not be 0 ccm or less";
    public static final String ILLEGAL_POWER = "Engine power may not be 0 hp or less";
    public static final String ILLEGAL_FUEL_TYPE = "Fuel type can not be null";

    private int volume;
    private int power;
    private FuelType fuelType;
    private boolean isOn = false;
    private int currentRpm = 0;
    private final int maxRpm;
    private final int minRpm;

    public static Engine DieselEngine(int volume, int power){
        return new Engine(volume, power, FuelType.Diesel);
    }

    public static Engine GasoleneEngine(int volume, int power){
        return new Engine(volume, power, FuelType.Petrol);
    }

    public Engine(int volume, int power, FuelType fuelType){
        this.setVolume(volume);
        this.setPower(power);
        this.setFuelType(fuelType);
        this.isOn = false;
        this.currentRpm = 0;
        this.minRpm = 800;
        this.maxRpm = 6500;
    }

    public void turnOn(){
        if(!this.isOn){
            this.isOn = true;
            idle();
        }
    }


    public void turnOff(){
        if(this.isOn){
            this.isOn = false;
        }
    }

    public int getRpm(){
        return this.currentRpm;
    }

    public int idle(){
        if(this.isOn){
            this.currentRpm = this.minRpm;
        }
        return this.currentRpm;
    }

    public boolean isRunning(){
        return this.isOn;
    }

    public boolean canHandleRpm(int rpm){
        return rpm <= this.maxRpm;
    }

    public int goFlatOut(){
        this.currentRpm = this.maxRpm;
        return this.currentRpm;
    }

    public int setRpm(int desiredRpm){
        if(!this.isOn){
            return 0;
        }
        if(desiredRpm == this.currentRpm){
            return this.currentRpm;
        }
        if(desiredRpm < this.currentRpm){
            if(desiredRpm <= this.minRpm){
                return idle();
            }
            this.currentRpm -= (this.currentRpm - desiredRpm);
        }
        else{
            if(desiredRpm >= this.maxRpm){
                this.currentRpm = this.maxRpm;

            }
            else {
                this.currentRpm += (desiredRpm - this.currentRpm);
            }
        }

        return this.currentRpm;
    }

    private void setVolume(int volume) throws IllegalArgumentException {
        if(volume <= 0){
            throw new IllegalArgumentException(ILLEGAL_VOLUME);
        }
        this.volume = volume;
    }

    private void setPower(int power) throws IllegalArgumentException {
        if(power <= 0){
            throw new IllegalArgumentException(ILLEGAL_POWER);
        }
        this.power = power;
    }

    private void setFuelType(FuelType fuelType){
        if(fuelType == null){
            throw new IllegalArgumentException(ILLEGAL_FUEL_TYPE);
        }
        this.fuelType = fuelType;
    }
}
