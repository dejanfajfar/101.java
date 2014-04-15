package com.fajfar.java101.lesson2.factory;

public interface Factory {
    static final String COMPLEX_PARAM_INVALID = "Provided parameters for this class should be <int>, <String>";
    static final String UNKNOWN_TYPE = "Type %s is not known to the factory";

    <T> T getInstance(Class<T> desiredType, Object...parameters);
}
