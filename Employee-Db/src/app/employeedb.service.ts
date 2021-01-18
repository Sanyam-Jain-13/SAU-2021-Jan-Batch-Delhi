import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class EmployeedbService {

  employeeList = [
    {empid : "101", name : "Shruti", address:"Uttam Nagar, Delhi", dob : "1997-08-25"},
    {empid : "102", name : "Sanyam", address:"abc/12 Rajouri, Delhi", dob : "1997-05-26"},
    {empid : "103", name : "Disha", address:"Ashok Vihar Delhi", dob : "1997-04-16"},
    {empid : "104", name : "Anisha", address: "10/9 Rohini, Delhi", dob : "1997-01-18"},
    {empid : "105", name : "Pradeep", address: "Saket, Delhi", dob : "1997-10-08"}
  ];

  constructor() { }

  getEmployees(){
    return this.employeeList;
  }

  getEmployeeByIndex(index){
    return this.employeeList[index];
  }

  addEmployee(employee){
    this.employeeList.push(employee);
    // console.log(this.employeeList);
  }

  deleteEmployeeByIndex(index){
    this.employeeList.splice(index, 1);
    // console.log(this.employeeList);
  }

  updateEmployeeByIndex(index, employee){
    this.employeeList[index] = employee;
    // console.log(this.employeeList);
  }

}
