package com.fajfar.java101.lesson2.factory.tests;

import com.fajfar.java101.lesson2.factory.Factory;
import com.fajfar.java101.lesson2.factory.implementation.ReflectiveFactory;
import com.fajfar.java101.lesson2.factory.model.ClassA;
import com.fajfar.java101.lesson2.factory.model.ClassB;
import com.fajfar.java101.lesson2.factory.model.ComplexClass;
import com.fajfar.java101.lesson2.factory.model.UnknownComplex;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class FactoryTests {

    private final String TEST_STRING = "Test";

    private Factory testFactory;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp(){
        testFactory = new ReflectiveFactory();
    }

    @Test
    public void Create_ClassA(){
        ClassA instance = testFactory.getInstance(ClassA.class);
        assertThat(instance, instanceOf(ClassA.class));
    }

    @Test
    public void Create_ClassB(){
        ClassB instance = testFactory.getInstance(ClassB.class);
        assertThat(instance, instanceOf(ClassB.class));
    }

    @Test
    public void Create_Compex_Object(){
        ComplexClass instance = testFactory.getInstance(ComplexClass.class, 5, TEST_STRING);
        assertThat(instance, instanceOf(ComplexClass.class));
        assertThat(instance.getA(), is(5));
        assertThat(instance.getB(), is(TEST_STRING));
    }

    @Test
    public void Create_Unknown_Complex_Object(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(format(ReflectiveFactory.UNKNOWN_TYPE, UnknownComplex.class));
        testFactory.getInstance(UnknownComplex.class, 1);
    }

    @Test
    public void Create_Known_Complex_Object_With_Invalid_Parameters(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(ReflectiveFactory.COMPLEX_PARAM_INVALID);
        testFactory.getInstance(ComplexClass.class, 1);
    }
}
