package com.fajfar.java101.lesson2.bonus;

public abstract class BaseFoo implements StringFoo {

    @Override
    public boolean containsUpperCaseCharacter(String inputString) {
        if(inputString == null || inputString.isEmpty()){
            return false;
        }
        return doUpperCaseCheck(inputString);
    }

    protected abstract boolean doUpperCaseCheck(String string);
}
