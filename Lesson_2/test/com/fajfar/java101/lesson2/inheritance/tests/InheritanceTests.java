package com.fajfar.java101.lesson2.inheritance.tests;

import com.fajfar.java101.lesson2.inheritance.Father;
import com.fajfar.java101.lesson2.inheritance.Grandfather;
import com.fajfar.java101.lesson2.inheritance.Son;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class InheritanceTests {

    @Test
    public void Constructor_Call_Chain(){
        new Son();
        new Father();
        new Grandfather();
    }

    @Test
    public void Invariant_Assignment(){
        assertThat(new Son(), instanceOf(Grandfather.class));
    }

    @Test
    public void Contravariant_Assignment(){
        assertThat(new Grandfather(), not(instanceOf(Son.class)));
    }

    @Test
    public void When_CreatingGrantfather_Then_AgeIs65(){
        Grandfather testObject = new Grandfather();
        assertThat(testObject.getAge(), is(65));
    }

    @Test
    public void When_CreatingFather_Then_AgeIs45(){
        Father testObject = new Father();
        assertThat(testObject.getAge(), is(45));
    }

    @Test
    public void When_CreatingSon_Then_Age25(){
        Grandfather testObject = new Son();
        assertThat(testObject.getAge(), is(25));
    }
}
