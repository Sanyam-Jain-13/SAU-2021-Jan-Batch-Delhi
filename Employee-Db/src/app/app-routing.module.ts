import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { ListEmployeeComponent } from './list-employee/list-employee.component';

const routes: Routes = [
  {path: "listEmployees", component: ListEmployeeComponent},
  {path: "employeeForm/:index", component: EmployeeFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
