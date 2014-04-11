package com.fajfar.java101.lesson2.inheritance;

public class Grandfather {

    public Grandfather(){
        System.out.println("I am a Grandfather");

        this.age = 65;
    }

    protected int age;

    public int getAge(){
        return this.age;
    }
}
