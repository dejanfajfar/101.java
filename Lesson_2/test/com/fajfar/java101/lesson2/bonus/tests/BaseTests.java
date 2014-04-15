package com.fajfar.java101.lesson2.bonus.tests;

import com.fajfar.java101.lesson2.bonus.StringFoo;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public abstract class BaseTests {
    public static final String SUCCESS_STRING = "I have Some Upper Case letters";
    public static final String FAIL_STRING = "i have not upper case letters";

    private StringFoo testSubject;

    @Before
    public abstract void setUp();

    protected void setTestSubject(StringFoo testSubject){
        this.testSubject = testSubject;
    }

    @Test
    public void Given_String_With_UpperCasseLetter_Then_True(){
        assertThat(this.testSubject.containsUpperCaseCharacter(SUCCESS_STRING), is(true));
    }

    @Test
    public void Given_StringWithoutUpperCaseLettrs_Then_False(){
        assertThat(this.testSubject.containsUpperCaseCharacter(FAIL_STRING), is(false));
    }
}
