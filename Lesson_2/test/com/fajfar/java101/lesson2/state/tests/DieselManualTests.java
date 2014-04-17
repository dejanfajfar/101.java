package com.fajfar.java101.lesson2.state.tests;

import com.fajfar.java101.lesson2.state.CarController;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DieselManualTests extends BaseTest {
    public DieselManualTests(){
        super(() -> CarController.getDieselManual());
    }

    @Test
    public void shiftUp_AsExpected(){
        assertThat(this.testObject.shiftUp(), is(1));
        assertThat(this.testObject.shiftUp(), is(2));
        assertThat(this.testObject.shiftUp(), is(3));
        assertThat(this.testObject.shiftUp(), is(4));
        assertThat(this.testObject.shiftUp(), is(5));
        assertThat(this.testObject.shiftUp(), is(0));
        assertThat(this.testObject.shiftUp(), is(1));
    }

    @Test
    public void getFuelType_AsExpected(){
        assertThat(this.testObject.getFuelType(), is("Diesel"));
    }

    @Test
    public void getFuelConsumption_AsExpected(){
        assertThat(this.testObject.getFuelConsumption(), is(5.7));
    }

    @Test
    public void shiftDown_AsExpected(){
        assertThat(this.testObject.shiftUp(), is(1));
        assertThat(this.testObject.shiftUp(), is(2));
        assertThat(this.testObject.shiftUp(), is(3));
        assertThat(this.testObject.shiftUp(), is(4));
        assertThat(this.testObject.shiftUp(), is(5));

        assertThat(this.testObject.shiftDown(), is(4));
        assertThat(this.testObject.shiftDown(), is(3));
        assertThat(this.testObject.shiftDown(), is(2));
        assertThat(this.testObject.shiftDown(), is(1));
        assertThat(this.testObject.shiftDown(), is(0));
        assertThat(this.testObject.shiftDown(), is(0));
    }
}
