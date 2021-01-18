import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeedbService } from '../employeedb.service';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.scss']
})
export class EmployeeFormComponent implements OnInit {

  editmode = false;

  EmpFormGroup = new FormGroup({
    empid : new FormControl('', Validators.required),
    name : new FormControl('', Validators.required),
    address : new FormControl('', Validators.required),
    dob: new FormControl('', Validators.required)
  });


  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private employeedb : EmployeedbService
    ) { }

  ngOnInit(): void {

    let index = this.route.snapshot.params['index'];
    this.editmode = index == '' ? false:true;

    if(this.editmode){
      let oldEmployee = this.employeedb.getEmployeeByIndex(index);
      // console.log(oldEmployee);
      this.fillForm(oldEmployee);
      // console.log(this.editmode);
    }

  }

  submitEmployee = () => {
    // console.log(JSON.stringify(this.EmpFormGroup.value));
    let employeeObj = this.EmpFormGroup.value;
    if(!this.editmode){
      this.employeedb.addEmployee(employeeObj);
      alert('Employee Added: ' + JSON.stringify(employeeObj));
      this.router.navigate(['']);
    }
    else{
      let index = this.route.snapshot.params['index'];
      this.employeedb.updateEmployeeByIndex(index, employeeObj);
      alert('Employee Update: ' + JSON.stringify(employeeObj));
      this.router.navigate(['listEmployees']);
    }
  }

  fillForm = (data) => {
    this.EmpFormGroup.setValue({
      name: data.name,
      empid: data.empid,
      address: data.address,
      dob: data.dob
    });
  }

}
