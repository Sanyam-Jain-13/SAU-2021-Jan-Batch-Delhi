import { Component, OnInit } from '@angular/core';
import { EmployeedbService } from '../employeedb.service';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.scss']
})
export class ListEmployeeComponent implements OnInit {

  employees = [];

  constructor(private employeedb : EmployeedbService) { }

  ngOnInit(): void {
    this.employees = this.employeedb.getEmployees();
    // console.log('oninit', this.employees);
  }

  deleteEmployee = (index) => {
    let deletedEmp = this.employeedb.getEmployeeByIndex(index);
    this.employeedb.deleteEmployeeByIndex(index);
    alert("Employee deleted: \n" + JSON.stringify(deletedEmp));
  }

}
