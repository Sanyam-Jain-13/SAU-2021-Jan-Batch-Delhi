package com.employee.employeeExample.controller;

import com.employee.employeeExample.model.Employee;
import com.employee.employeeExample.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class employeeController {

    @Autowired
    employeeRepository employeeRepository;


//    @RequestMapping("/") public String index() {
//
//        return "Welcome to the CRUD application!!";
//    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable String id) {
        if (employeeRepository.existsById(id)) {
            return employeeRepository.findById(id);
        } else
            return Optional.empty();
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee e){

        return employeeRepository.save(e);
    }

    @DeleteMapping("/employee/id/{id}")
    public void deleteEmployeeById(@PathVariable String id) {

        employeeRepository.deleteById(id);
    }

    @GetMapping("/employee/pincode/{pincode}")
    public List getEmployeeByLocationAndPincode(@PathVariable String address,
                                                @PathVariable String pincode){

        return employeeRepository.findByAddressAndPincode(address,pincode);
    }


}
