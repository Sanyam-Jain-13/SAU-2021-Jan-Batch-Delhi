package com.paysquare;

import com.paysquare.model.Employee;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.paysquare.Database.EmployeeDb.*;

public class PaySquareApplication implements Runnable{


    public static void main(String[] args) {

        Long delayTime;

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Long initialDelay = LocalDateTime.now().until(LocalDate.now().plusDays(1).atTime(15, 00), ChronoUnit.MINUTES);

        if (initialDelay > TimeUnit.DAYS.toMinutes(15)) {
            delayTime = LocalDateTime.now().until(LocalDate.now().atTime(15, 00), ChronoUnit.MINUTES);
        } else {
            delayTime = initialDelay;
        }

        scheduler.scheduleAtFixedRate(new PaySquareApplication(), delayTime, 15, TimeUnit.DAYS);

    }
    @Override
    public void run()
    {
        System.out.println("\n ========= PaySquare Application =========");

        createEmployees();

        Map<String, Employee> employeeList = getEmployeeList();
        Employee employee;

        for (String i : employeeList.keySet()) {
            employee =  employeeList.get(i);
            double value = employee.calculateSalaryPaid(30); // avgeage days in a month
            employee.setSalaryPaid(value);
//                employee.displayDetails();
            setService(employee, employee.getPreferredMode());
        }

    }

}


