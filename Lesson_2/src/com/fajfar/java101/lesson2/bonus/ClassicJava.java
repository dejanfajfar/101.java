package com.fajfar.java101.lesson2.bonus;

public class ClassicJava extends BaseFoo {

    @Override
    protected boolean doUpperCaseCheck(String string) {
        for(char character : string.toCharArray()){
            if(Character.isUpperCase(character)){
                return true;
            }
        }
        return false;
    }
}
