package com.fajfar.java101.lesson2.strategy;

public interface Writer {
    static final String INVALID_INPUT_STRING = "The provided input string is null or empty";

    String write(String inputString);
}
