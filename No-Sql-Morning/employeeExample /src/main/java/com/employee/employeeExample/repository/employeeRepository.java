package com.employee.employeeExample.repository;

import com.employee.employeeExample.model.Employee;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface employeeRepository extends CrudRepository<Employee, String> {

	List findByAddressAndPincode(String address, String pincode);
	   
}