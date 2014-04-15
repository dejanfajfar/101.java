package com.fajfar.java101.lesson2.factory.tests;

import com.fajfar.java101.lesson2.factory.implementation.SimpleFactory;

public class SimpleFactoryTests extends FactoryTests {

    @Override
    public void setUp() {
        this.testFactory = new SimpleFactory();
    }
}
