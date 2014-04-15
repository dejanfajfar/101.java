package com.fajfar.java101.lesson2.state.tests;

import com.fajfar.java101.lesson2.state.Car;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DieselTests {

    @Test
    public void Foo(){
        Car testCar = CarController.getDieselManual();

        assertThat(testCar.shiftUp(), is(1));
    }
}
