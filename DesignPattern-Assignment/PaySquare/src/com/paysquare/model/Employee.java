package com.paysquare.model;

public abstract class Employee {

    private int empId;
    private String name;
    private String emailId;
    private String phone;
    private int leavesTaken;
    private double salaryPaid;
    private char preferredMode; // 1-sms, 2-email, 3-both


    public Employee() {
    }

    public Employee(int empId, String name, String emailId, String phone, int leavesTaken) {
        this.empId = empId;
        this.name = name;
        this.emailId = emailId;
        this.phone = phone;
        this.leavesTaken = leavesTaken;
    }

    /*  method to calculate NET salary */
    public abstract double calculateSalaryPaid(int daysInMonth);


    /* Display employee details */
    public void displayDetails(){

        System.out.println("\nEmployee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", salaryPaid='" + salaryPaid + '\'' +
                ", phone='" + phone + '\'' +
                ", leavesTaken=" + leavesTaken +
                '}');
    }


    /* Getters and Setters */

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalaryPaid() {
        return salaryPaid;
    }

    public void setSalaryPaid(double salaryPaid){
        this.salaryPaid = salaryPaid;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLeavesTaken() {
        return leavesTaken;
    }

    public void setLeavesTaken(int leavesTaken) {
        this.leavesTaken = leavesTaken;
    }

    public char getPreferredMode() {
        return preferredMode;
    }

    public void setPreferredMode(char preferredMode) {
        this.preferredMode = preferredMode;
    }
}
