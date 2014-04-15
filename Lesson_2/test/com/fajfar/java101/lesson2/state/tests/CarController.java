package com.fajfar.java101.lesson2.state.tests;

import com.fajfar.java101.lesson2.state.Car;
import com.fajfar.java101.lesson2.state.DieselManual;

public class CarController {


    public static Car getDieselManual(){
        return new DieselManual();
    }
}
