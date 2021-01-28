package com.paysquare.Service;

import com.paysquare.model.Employee;

public class SMS extends NotificationMedium {

    public SMS(){}

    @Override
    public void getNotification(Employee employee) {
        System.out.print("\n---- SMS sent to ----");
        employee.displayDetails();

    }



}
