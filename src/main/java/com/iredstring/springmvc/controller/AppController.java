package com.iredstring.springmvc.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iredstring.springmvc.model.Employee;
import com.iredstring.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/api/emp")
public class AppController {

	@Autowired
	EmployeeService service;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Employee> employees = service.findAllEmployees();
//		Employee peter = new Employee();
//		peter.setName("peter");
//		peter.setJoiningDate(new LocalDate("2010-01-11"));
//		peter.setSalary(new BigDecimal("101000"));
//		peter.setSsn("ssn1");
//
//		Employee nancy = new Employee();
//		nancy.setName("nancy");
//		nancy.setJoiningDate(new LocalDate("2010-02-13"));
//		nancy.setSalary(new BigDecimal("102000"));
//		nancy.setSsn("ssn2");
//		
//		List<Employee>employees = new ArrayList<Employee>();
//		employees.add(peter);
//		employees.add(nancy);
		
		model.addAttribute("employees", employees);
		return "allemployees";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		service.saveEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName()
				+ " registered successfully");
		return "success";
	}

	/*
	 * This method will delete an employee by it's SSN value.
	 * Example http://tomcatApp/webapi/delete?ssn=ssnabc
	 */
	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	
	public String deleteEmployee(
			@RequestParam(value = "ssn", required = false, defaultValue = "") String ssn, Model model) {
		
		service.deleteEmployeeBySsn(ssn);
		return "redirect:/api/emp/list";
	}
	
	
	

}
