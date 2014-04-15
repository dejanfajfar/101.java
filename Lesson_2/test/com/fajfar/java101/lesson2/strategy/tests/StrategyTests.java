package com.fajfar.java101.lesson2.strategy.tests;

import com.fajfar.java101.lesson2.strategy.RemoveVowels;
import com.fajfar.java101.lesson2.strategy.UpperCaseWriter;
import com.fajfar.java101.lesson2.strategy.Writer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StrategyTests {

    @Test
    public void StateTest(){
        List<Writer> stateList = new ArrayList<Writer>();
        stateList.add(new UpperCaseWriter());
        stateList.add(new RemoveVowels());

        String testString = "We are the champions";

        for(Writer w : stateList){
            testString = w.write(testString);
        }

       assertThat(testString, is("W R TH CHMPNS"));
    }
}
