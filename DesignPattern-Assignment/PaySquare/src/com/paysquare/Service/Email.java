package com.paysquare.Service;

import com.paysquare.model.Employee;

public class Email extends NotificationMedium {


    public Email(){ }

    @Override
    public void getNotification(Employee employee) {
        System.out.print("\n---- Email sent to ----");
        employee.displayDetails();
    }



}
