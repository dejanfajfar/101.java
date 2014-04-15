package com.fajfar.java101.lesson2.state;

public abstract class AbstractBaseWritter implements Writer {

    @Override
    public String write(String inputString) {
        if(inputString == null || inputString.isEmpty()){
            throw new IllegalArgumentException(INVALID_INPUT_STRING);
        }

        return doWrite(inputString);
    }

    protected abstract String doWrite(String inputString);
}
