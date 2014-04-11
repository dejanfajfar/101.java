package com.fajfar.java101.withinterface.tests;


import com.fajfar.java101.lesson1.withInterfaces.Car;
import com.fajfar.java101.lesson1.withInterfaces.Engine;
import com.fajfar.java101.lesson1.withInterfaces.Transmission;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class CarTests {

    @Test
    public void Given_A_Valid_Car_Then_Make_OK(){
        Engine testEngine = mock(Engine.class);
        Transmission testTransmission = mock(Transmission.class);

        Car car = new Car("BMW", "525d", testEngine, testTransmission);
        assertThat(car.getCarMake(), is("BMW-525d"));
    }

    @Test
    public void Given_A_Valid_Car_Do_Something(){
        Engine testEngine = mock(Engine.class);
        Transmission testTransmission = mock((Transmission.class));

        Car dieselCar = new Car("BMW", "525d", testEngine, testTransmission);

        when(testEngine.isRunning()).thenReturn(true);
        when(testEngine.canHandleRpm(4000)).thenReturn(true);
        when(testEngine.canHandleRpm(6000)).thenReturn(true);
        when(testEngine.canHandleRpm(8000)).thenReturn(false);
        when(testEngine.goFlatOut()).thenReturn(6500);
        when(testEngine.getRpm()).thenReturn(800, 4000, 6000, 6500);
        when(testTransmission.calculateSpeed(anyInt())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] arguments = invocationOnMock.getArguments();
                int parameter = (Integer) arguments[0];

                return parameter / 100;
            }
        });

        when(testTransmission.calculateRpm(anyInt())).thenCallRealMethod();

        when(testTransmission.calculateRpm(anyInt())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] arguments = invocationOnMock.getArguments();
                int parameter = (Integer) arguments[0];

                return parameter * 100;
            }
        });

        dieselCar.startTheEngine();

        assertThat(testEngine.isRunning(), is(true));
        assertThat(testEngine.getRpm(), is(800));
        assertThat(dieselCar.getCurrentSpeed(), is(0));

        dieselCar.accelerate(40);

        assertThat(testEngine.getRpm(), is(testTransmission.calculateRpm(40)));
        assertThat(dieselCar.getCurrentSpeed(), is(40));

        dieselCar.accelerate(20);

        assertThat(testEngine.getRpm(), is(testTransmission.calculateRpm(60)));
        assertThat(dieselCar.getCurrentSpeed(), is(60));

        dieselCar.accelerate(20);

        assertThat(testEngine.getRpm(), is(testTransmission.calculateRpm(65)));
        assertThat(dieselCar.getCurrentSpeed(), is(65));
    }
}
