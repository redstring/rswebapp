package com.iredstring.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iredstring.springmvc.model.Employee;
import com.iredstring.springmvc.model.Person;
import com.iredstring.springmvc.service.EmployeeService;
import com.iredstring.springmvc.service.PersonService;

@Controller
@RequestMapping("/v1")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private EmployeeService empService;

	
	//Testing URL: /mobile/person?username=peter
	//This is more like traditional php style, use this styple
	@RequestMapping(value="/person", method = RequestMethod.GET)
	public ModelAndView findPersonByName(
			@RequestParam("username") String username) {
		
		System.out.println("in controller:"+username);
		
		Person person = personService.getPersonByUsername(username);
		
		String strP = personService.getPersonJsonByUsername(username);
		ModelAndView mv = new ModelAndView("person");
		mv.addObject("irsid", person.getIrsId());
		mv.addObject("firstname", person.getFirstName());
		mv.addObject("lastname", person.getLastName());
		mv.addObject("username", person.getUserName());
		mv.addObject("userpassword", person.getUserName());
		mv.addObject("message", strP);
		
		return mv;
	}
	
	//This is more like REST style
	@RequestMapping(value="/person/read/{username}", method = RequestMethod.GET)
	public ModelAndView findPersonByUsername(
	  @PathVariable("username") String username){
		
		Person person = personService.getPersonByUsername(username);
		String strP = personService.getPersonJsonByUsername(username);
		ModelAndView mv = new ModelAndView("person");
		mv.addObject("irsid", person.getIrsId());
		mv.addObject("firstname", person.getFirstName());
		mv.addObject("lastname", person.getLastName());
		mv.addObject("username", person.getUserName());
		mv.addObject("userpassword", person.getUserName());
		mv.addObject("message", strP);
		return mv;

	   
	}

	
	@RequestMapping(value = { "/person/list" }, method = RequestMethod.GET)
	public String listPeople(ModelMap model) {

		List<Person> people = personService.findAllPeople();
		model.addAttribute("people", people);
		return "allpeople";
	}
	
	/*
	 * This method will delete a p by it's username value.
	 */
	@RequestMapping(value = { "/person/delete/{username}" }, method = RequestMethod.GET)
	public String deleteOnePerson(@PathVariable String username) {
		personService.deletePersonByUsername(username);
		return "redirect:/api/v1/person/list";
	}
	
}
