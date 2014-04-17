package com.fajfar.java101.lesson2.state.tests;

import com.fajfar.java101.lesson2.state.CarController;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PetrolAutomaticTests extends BaseTest {
    public PetrolAutomaticTests() {
        super(() -> CarController.getPetrolAutomatic());
    }

    @Test
    public void shiftUp_AsExpected(){
        assertThat(this.testObject.shiftUp(), is(0));
        assertThat(this.testObject.shiftUp(), is(0));
    }

    @Test
    public void getFuelType_AsExpected(){
        assertThat(this.testObject.getFuelType(), is("Petrol"));
    }

    @Test
    public void getFuelConsumption_AsExpected(){
        assertThat(this.testObject.getFuelConsumption(), is(10.3));
    }

    @Test
    public void shiftDown_AsExpected(){
        assertThat(this.testObject.shiftDown(), is(0));
        assertThat(this.testObject.shiftDown(), is(0));
    }
}
