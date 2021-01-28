package com.paysquare.Database;

import com.paysquare.Factory.EmployeeFactory;
import com.paysquare.Service.Email;
import com.paysquare.Service.NotificationMedium;
import com.paysquare.Service.SMS;
import com.paysquare.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDb {

    //Employee map
    private static Map<String,Employee> employeeList = new HashMap<>();

    public static void createEmployees(){

        //Employee Factory object
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee employee;


        // manager
        employee = employeeFactory.getEmployee("manager");
        employee.setEmpId(101);
        employee.setName("Rohan");
        employee.setEmailId("rohan@accolite.com");
        employee.setPhone("9911228833");
        employee.setLeavesTaken(2);
        employee.setPreferredMode('1');
        employeeList.put(employee.getName(), employee);


        employee = employeeFactory.getEmployee("manager", 220000.0);
        employee.setEmpId(102);
        employee.setName("Sam");
        employee.setEmailId("sam@accolite.com");
        employee.setPhone("9900028833");
        employee.setLeavesTaken(3);
        employee.setPreferredMode('3');
        employeeList.put(employee.getName(), employee);

        // sde 2
        employee = employeeFactory.getEmployee("sde_2");
        employee.setEmpId(201);
        employee.setName("Shalu");
        employee.setEmailId("shalu@accolite.com");
        employee.setPhone("9900008833");
        employee.setLeavesTaken(1);
        employee.setPreferredMode('2');
        employeeList.put(employee.getName(), employee);

        // sde 1
        employee = employeeFactory.getEmployee("sde_1", 70000.0);
        employee.setEmpId(301);
        employee.setName("Dian");
        employee.setEmailId("dian@accolite.com");
        employee.setPhone("9801220833");
        employee.setLeavesTaken(0);
        employee.setPreferredMode('1');
        employeeList.put(employee.getName(), employee);

        // intern
        employee = employeeFactory.getEmployee("intern");
        employee.setEmpId(401);
        employee.setName("Aayat");
        employee.setEmailId("aayat@accolite.com");
        employee.setPhone("9811028133");
        employee.setLeavesTaken(2);
        employee.setPreferredMode('2');
        employeeList.put(employee.getName(), employee);

    }

    public static void setService(Employee employee, char modeOfCommunication){
        /*
            SMS - 1
            EMAIL - 2
            BOTH - 3 or default
        */

        NotificationMedium notification;

        if(modeOfCommunication == '1' || modeOfCommunication == '3') {
            notification = new SMS();
            notification.getNotification(employee);
        }
        if(modeOfCommunication == '2' || modeOfCommunication == '3'){
            notification = new Email();
            notification.getNotification(employee);
        }
    }

    public static Map<String, Employee> getEmployeeList() {
        return employeeList;
    }
}
