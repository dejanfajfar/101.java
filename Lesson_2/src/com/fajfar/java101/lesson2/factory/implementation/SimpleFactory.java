package com.fajfar.java101.lesson2.factory.implementation;

import com.fajfar.java101.lesson2.factory.Factory;
import com.fajfar.java101.lesson2.factory.model.ClassA;
import com.fajfar.java101.lesson2.factory.model.ClassB;
import com.fajfar.java101.lesson2.factory.model.ComplexClass;

public class SimpleFactory implements Factory {

    @Override
    public <T> T getInstance(Class<T> desiredType, Object... parameters) {
        if(desiredType == ClassA.class){
            return (T) new ClassA();
        }
        else if(desiredType == ClassB.class){
            return (T) new ClassB();
        }
        else if(desiredType == ComplexClass.class){
            if (parameters.length != 2) {
                throw new IllegalArgumentException(COMPLEX_PARAM_INVALID);
            }
            return (T) new ComplexClass((Integer)parameters[0], (String)parameters[1]);
        }

        throw new IllegalArgumentException(String.format(UNKNOWN_TYPE, desiredType));
    }
}
