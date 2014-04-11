package com.fajfar.java101.lesson2.factory;


public interface Initializer<T> {
    T initialize(Object...parameters);
}
