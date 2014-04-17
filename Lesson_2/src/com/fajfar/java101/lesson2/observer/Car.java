package com.fajfar.java101.lesson2.observer;

import java.util.Observable;

/**
 * Created by fajfarde on 15/04/14.
 */
public class Car extends Observable {
    public void Foo(){
        this.notifyObservers("Rosemarie");
    }

    public void seetSpeed(int newSpeed){
        this.notifyObservers(newSpeed);
    }
}
