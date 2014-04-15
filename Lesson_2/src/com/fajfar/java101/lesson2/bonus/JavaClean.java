package com.fajfar.java101.lesson2.bonus;

public class JavaClean extends BaseFoo {

    @Override
    protected boolean doUpperCaseCheck(String string) {
        return exists(string, new PropertyCheck<Character>() {
            @Override
            public boolean hasProperty(Character testSubject) {
                return Character.isUpperCase(testSubject);
            }
        });
    }

    private boolean exists(String input, PropertyCheck<Character> prdicate){
        for(char c : input.toCharArray()){
            if(prdicate.hasProperty(c)){
                return true;
            }
        }
        return false;
    }

    interface PropertyCheck<T>{
        boolean hasProperty(T testSubject);
    }
}
