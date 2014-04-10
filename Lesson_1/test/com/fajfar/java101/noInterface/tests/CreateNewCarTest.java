package com.fajfar.java101.noInterface.tests;

import com.fajfar.java101.lesson1.noInterface.Car;
import com.fajfar.java101.lesson1.noInterface.Engine;
import com.fajfar.java101.lesson1.noInterface.Transmission;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class CreateNewCarTest {


    @Test
    public void Given_A_Valid_Car_Then_Make_OK(){
        Car car = new Car("BMW", "525d", Engine.DieselEngine(2499, 150), new Transmission());
        assertThat(car.getCarMake(), is("BMW-525d"));
    }

    @Test
    public void Given_A_Valid_Car_Do_Something(){
        Engine testEngine = Engine.DieselEngine(2499, 150);
        Transmission testTransmission = new Transmission();

        Car dieselCar = new Car("BMW", "525d", testEngine, testTransmission);

        dieselCar.startTheEngine();

        assertThat(testEngine.isRunning(), is(true));
        assertThat(testEngine.getRpm(), is(800));
        assertThat(dieselCar.getCurrentSpeed(), is(0));

        dieselCar.accelerate(40);

        assertThat(testEngine.getRpm(), is(testTransmission.calculateRpm(40)));
        assertThat(dieselCar.getCurrentSpeed(), is(40));

        dieselCar.accelerate(20);

        assertThat(testEngine.getRpm(), is(testTransmission.calculateRpm(60)));
        assertThat(dieselCar.getCurrentSpeed(), is(60));

        dieselCar.accelerate(20);

        assertThat(testEngine.getRpm(), is(testTransmission.calculateRpm(65)));
        assertThat(dieselCar.getCurrentSpeed(), is(65));
    }
}
