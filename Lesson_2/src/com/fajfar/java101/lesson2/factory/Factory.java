package com.fajfar.java101.lesson2.factory;

public interface Factory {

    <T> T getInstance(Class<T> desiredType, Object...parameters);
}
