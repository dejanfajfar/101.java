package com.fajfar.java101.lesson2.factory.implementation;


import com.fajfar.java101.lesson2.factory.Factory;
import com.fajfar.java101.lesson2.factory.Initializer;
import com.fajfar.java101.lesson2.factory.model.ComplexClass;

import java.lang.reflect.Constructor;
import java.util.Hashtable;

public class ReflectiveFactory implements Factory {

    public static final String UNKNOWN_TYPE = "Type %s is not known to the factory";
    public static final String COMPLEX_PARAM_INVALID = "Provided parameters for this class should be <int>, <String>";

    private Hashtable<Class, Initializer> specialCases;

    public ReflectiveFactory(){
        specialCases = new Hashtable<Class, Initializer>();
        registerSpecialCases();
    }

    private void registerSpecialCases() {
        specialCases.put(ComplexClass.class, new Initializer<ComplexClass>() {
            @Override
            public ComplexClass initialize(Object... parameters) {
                if (parameters.length != 2) {
                    throw new IllegalArgumentException(COMPLEX_PARAM_INVALID);
                }
                return new ComplexClass((Integer) parameters[0], (String) parameters[1]);
            }
        });
    }

    @Override
    public <T> T getInstance(Class<T> desiredType, Object... parameters) {
        if(specialCases.containsKey(desiredType)){
            return (T) specialCases.get(desiredType).initialize(parameters);
        }

        try {
            Constructor<?> defaultConstructor = desiredType.getConstructor();
            return (T) defaultConstructor.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(UNKNOWN_TYPE, desiredType));
        }
    }
}
