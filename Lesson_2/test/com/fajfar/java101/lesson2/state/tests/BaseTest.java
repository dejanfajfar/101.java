package com.fajfar.java101.lesson2.state.tests;

import com.fajfar.java101.lesson2.state.CarController;
import org.junit.Before;

import java.util.function.Supplier;

public class BaseTest {
    private Supplier<CarController> carControllerSupplier;

    public BaseTest(Supplier<CarController> controllerSupplier) {
        this.carControllerSupplier = controllerSupplier;
    }

    protected CarController testObject;

    @Before
    public void setUp()
    {
        testObject = carControllerSupplier.get();
    }
}
