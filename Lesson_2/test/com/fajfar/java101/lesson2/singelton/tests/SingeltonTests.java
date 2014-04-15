package com.fajfar.java101.lesson2.singelton.tests;

import com.fajfar.java101.lesson2.singelton.SalaryManager;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class SingeltonTests {

    private final String employee_Bob = "Bob";
    private final String employee_Jef = "Jef";

    private SalaryManager salaryManager;

    @Before
    public void SetUp(){
        salaryManager = SalaryManager.getInstance();
    }

    @Test
    public void Singelton_In_Action_Fixture(){
        salaryManager.setSalary(employee_Bob, 1000);
        salaryManager.setSalary(employee_Jef, 1100);

        salaryManager.payoutForEmployee(employee_Bob);

        leaveScope();

        assertThat(salaryManager.getTotalPayout(), is(2100d));
    }

    private void leaveScope(){
        SalaryManager.getInstance().payoutForEmployee(this.employee_Jef);
    }
}
