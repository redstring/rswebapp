package com.iredstring.springmvc.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iredstring.springmvc.model.RSUser;
import com.iredstring.springmvc.service.RSUserService;

@Controller
@RequestMapping("/api/v1/rsuser")
public class RSUserController {

	@Autowired
	RSUserService service;

	private static ObjectMapper mapper = new ObjectMapper();

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listRSUsers(Model model) {
		List<RSUser> listOfRSUsers = service.findAllRSUsers();

		String jsonString="";
		try {
			jsonString = mapper.writeValueAsString(listOfRSUsers);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		model.addAttribute("strvalue", jsonString);
		return "plaintext";
	}

	@RequestMapping(value = { "/read" }, method = RequestMethod.GET)
	public String readOneRSUserByRsid(@RequestParam("rsid") Long rsid, Model model) {
		RSUser rsuser = service.getRSUserByRsid(rsid);
		String jsonString=""; 
		try {
			jsonString= mapper.writeValueAsString(rsuser);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		model.addAttribute("strvalue", jsonString);
		return "plaintext";
	}

	// @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	// public String newRSUser(ModelMap model) {
	// RSUser
	// Employee employee = new Employee();
	// model.addAttribute("employee", employee);
	// return "registration";
	// }
	//
	// @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	// public String saveEmployee(@Valid Employee employee, BindingResult
	// result,
	// ModelMap model) {
	//
	// if (result.hasErrors()) {
	// return "registration";
	// }
	//
	// service.saveEmployee(employee);
	//
	// model.addAttribute("success", "Employee " + employee.getName()
	// + " registered successfully");
	// return "success";
	// }

	// @RequestMapping(value = { "/update" }, method = RequestMethod.GET)
	//
	// public String updateRSUser(
	// @RequestParam(value = "ssn", required = false, defaultValue = "") String
	// ssn, Model model) {
	//
	// service.updateRSUser(rsuer);
	// return "redirect:/api/emp/list";
	// }
	//

}
