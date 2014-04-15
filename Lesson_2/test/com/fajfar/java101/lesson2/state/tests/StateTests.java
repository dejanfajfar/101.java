package com.fajfar.java101.lesson2.state.tests;

import com.fajfar.java101.lesson2.state.RemoveVowels;
import com.fajfar.java101.lesson2.state.UpperCaseWriter;
import com.fajfar.java101.lesson2.state.Writer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StateTests {

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
