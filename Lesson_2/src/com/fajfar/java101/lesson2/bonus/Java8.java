package com.fajfar.java101.lesson2.bonus;

public class Java8 extends BaseFoo {

    @Override
    protected boolean doUpperCaseCheck(String string) {
        return string.chars().anyMatch((int c) -> Character.isUpperCase((char)c));
    }
}
