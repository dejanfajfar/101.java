package com.fajfar.java101.lesson2.factory.tests;

import com.fajfar.java101.lesson2.factory.implementation.ReflectiveFactory;

public class ReflectiveFactoryTests extends FactoryTests {
    @Override
    public void setUp() {
        this.testFactory = new ReflectiveFactory();
    }
}
