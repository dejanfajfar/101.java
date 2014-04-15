package com.fajfar.java101.lesson2.state;

public class LowerCaseWriter extends AbstractBaseWritter {

    @Override
    protected String doWrite(String inputString) {
        return inputString.toLowerCase();
    }
}
