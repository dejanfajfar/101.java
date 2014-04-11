package com.fajfar.java101.lesson2.factory.model;

public class ComplexClass {

    private final int a;
    private final String b;

    public ComplexClass(int a, String b){

        this.a = a;
        this.b = b;
    }

    public String getB() {
        return b;
    }

    public int getA() {
        return a;
    }
}
