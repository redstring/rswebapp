package com.iredstring.springmvc.service;

import java.util.List;

import com.iredstring.springmvc.model.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);
	
	List<Employee> findAllEmployees(); 
	
	void deleteEmployeeBySsn(String ssn);
}
