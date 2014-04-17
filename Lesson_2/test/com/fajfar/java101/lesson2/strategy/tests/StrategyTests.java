package com.fajfar.java101.lesson2.strategy.tests;

import com.fajfar.java101.lesson2.strategy.WriterAction;
import com.fajfar.java101.lesson2.strategy.WriterManager;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StrategyTests {
    private final String TEST_STRING = "We are the champions";

    private WriterManager testObject;

    @Before
    public void setUp(){
        testObject = new WriterManager();
    }

    @Test
    public void CompositeStrategy(){
        String result = testObject.applyWriterAction(TEST_STRING, WriterAction.UPPER_CASE, WriterAction.REMOVE_VOVELS);
        assertThat(result, is("W R TH CHMPNS"));
    }

    @Test
    public void SingleStrategy(){
        String result = testObject.applyWriterAction(TEST_STRING, WriterAction.LOWER_CASE);
        assertThat(result, is("we are the champions"));
    }

    @Test
    public void UnknownStrategy(){
        String result = testObject.applyWriterAction(TEST_STRING, WriterAction.FOO);
        assertThat(result, is(TEST_STRING));
    }
}
