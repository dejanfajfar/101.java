package com.fajfar.java101.noInterface.tests;

import com.fajfar.java101.lesson1.noInterface.Engine;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class EngineTests {
    private Engine testEngine;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void beforeTest(){
        testEngine = Engine.DieselEngine(1000, 80);
    }

    @Test
    public void Given_Valid_Engine_When_Started_Then_running(){
        testEngine.turnOn();
        assertThat(testEngine.isRunning(), is(true));
    }

    @Test
    public void Given_Running_Engine_When_Stoped_Then_Stoped(){
        testEngine.turnOn();
        testEngine.turnOff();
        assertThat(testEngine.isRunning(), is(false));
    }

    @Test
    public void Given_Running_Engine_When_Started_Then_Running(){
        testEngine.turnOn();
        testEngine.turnOn();
        assertThat(testEngine.isRunning(), is(true));
    }

    @Test
    public void Given_Running_Engine_When_Setting_Valid_Rpm_Then_OK(){
        testEngine.turnOn();
        testEngine.setRpm(2500);
        assertThat(testEngine.getRpm(), is(2500));
    }

    @Test
    public void Given_Running_Engine_When_Rpm_Checked_Then_800(){
        testEngine.turnOn();
        assertThat(testEngine.getRpm(), is(800));
    }

    @Test
    public void Given_StopedEngine_When_SetRpm_Then_RpmIs0(){
        testEngine.setRpm(2000);
        assertThat(testEngine.getRpm(), is(0));
    }

    @Test
    public void Given_ValidEngine_When_UnderIdle_Then_Idle(){
        testEngine.turnOn();
        testEngine.setRpm(200);
        assertThat(testEngine.getRpm(), is(800));
    }

    @Test
    public void Given_ValidEngine_When_DecreaseRpm_Then_OK(){
        testEngine.turnOn();
        testEngine.setRpm(2500);
        testEngine.setRpm(2000);
        assertThat(testEngine.getRpm(), is(2000));
    }

    @Test
    public void Given_ValidEngine_When_IncreaseRpm_Then_OK(){
        testEngine.turnOn();
        testEngine.setRpm(2000);
        testEngine.setRpm(2500);
        assertThat(testEngine.getRpm(), is(2500));
    }

    @Test
    public void Given_Valid_engine_When_Overreving_Then_MaxRpm(){
        testEngine.turnOn();
        testEngine.setRpm(7000);
        assertThat(testEngine.getRpm(), is(6500));
    }

    @Test
    public void When_InitializeEngineWithZeroVolume_Then_ExceptionThrown(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(Engine.ILLEGAL_VOLUME);
        testEngine = Engine.GasoleneEngine(0, 100);
    }

    @Test
    public void When_InitializeEngineWithNegativeVolume_Then_ExceptionThrown(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(Engine.ILLEGAL_VOLUME);
        testEngine = Engine.GasoleneEngine(-1, 100);
    }

    @Test
    public void When_InitializeEngineWithZeroPower_Then_ExceptionThrown(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(Engine.ILLEGAL_POWER);
        testEngine = Engine.GasoleneEngine(2000, 0);
    }

    @Test
    public void When_InitializeEngineWithNegativePower_Then_ExceptionThrown(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(Engine.ILLEGAL_POWER);
        testEngine = Engine.GasoleneEngine(2000, -1);
    }
}
