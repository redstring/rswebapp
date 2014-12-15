package com.rswebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rswebapp.service.DataService;
import com.rswebapp.model.*;

@Controller
public class PersonController {

	@Autowired
	private DataService dataService;

	//Testing URL: /mobile/person?username=peter
	//This is more like traditional php style, use this styple
	@RequestMapping(value="/mobile/person", method = RequestMethod.GET)
	public ModelAndView findPersonByName(
			@RequestParam("username") String username) {
		
		System.out.println("in controller:"+username);
		
		Person person = dataService.getPersonByUsername(username);
		
		String strP = dataService.getPersonJsonByUsername(username);
		ModelAndView mv = new ModelAndView("person");
		mv.addObject("name", username);
		mv.addObject("username", person.getUsername());
		mv.addObject("userpassword", person.getUserpassword());
		mv.addObject("firstname", person.getFirstname());
		mv.addObject("surname", person.getSurname());
		mv.addObject("message", strP);
		
		return mv;
	}
	
	//This is more like REST style
	@RequestMapping(value="/mobile/person/{username}", method = RequestMethod.GET)
	public ModelAndView findDepatmentAlternative(
	  @PathVariable("username") String username){
		
		Person person = dataService.getPersonByUsername(username);
		String strP = dataService.getPersonJsonByUsername(username);
		ModelAndView mv = new ModelAndView("person");
		mv.addObject("name", username);
		mv.addObject("username", person.getUsername());
		mv.addObject("userpassword", person.getUserpassword());
		mv.addObject("firstname", person.getFirstname());
		mv.addObject("surname", person.getSurname());
		mv.addObject("message", strP);
		return mv;

	   
	}
}
