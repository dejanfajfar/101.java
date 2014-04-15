package com.fajfar.java101.lesson2.singelton;

import java.util.Hashtable;
import java.util.Map;

public class SalaryManager {
    private SalaryManager(){
        this.salaryList = new Hashtable<String, Double>();
        this.totalPayout = 0d;
    }

    private static SalaryManager instance = null;

    public static SalaryManager getInstance(){
        if(instance == null){
            instance = new SalaryManager();
        }
        return instance;
    }

    private double totalPayout;
    private Map<String, Double> salaryList;

    public void setSalary(String employee, double salary){
        if(salaryList.containsKey(employee)){
            salaryList.replace(employee, salary);
        }
        else{
            salaryList.put(employee, salary);
        }
    }

    public double getTotalPayout(){
        return this.totalPayout;
    }

    public double payoutForEmployee(String employee){
        if(!salaryList.containsKey(employee)){
            return 0d;
        }

        double salary = salaryList.get(employee);

        this.totalPayout += salary;
        return salary;
    }
}
