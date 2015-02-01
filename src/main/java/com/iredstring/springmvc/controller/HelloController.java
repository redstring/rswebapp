/*   Copyright 2015, Tzu-Cheng Chuang (http://chuangtc.com) 
 *   Licensed under the MIT license. http://opensource.org/licenses/MIT
 */
package com.iredstring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Spring Original Controller will tightly bundled with an object in database
@Controller
public class HelloController {
	
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String home(Model model) {
	    return "home";
	}

	@RequestMapping("/api/hello")
	public String hello(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("strvalue", "1. Hello, "+name);
		return "plaintext";
	}

	// http://tomcatApp/webapi/hello2?name=aaaabbb
	@RequestMapping("/api/hello2")
	public String hello2(
			@RequestParam(value = "name", required = false, defaultValue = "World2") String name,
			Model model) {
		model.addAttribute("strvalue", "2. Hello, "+name);
		return "plaintext";
	}

	// http://tomcatApp/webapi/hello3/aaa
	@RequestMapping(value = "/api/hello3/{name}.do", method = RequestMethod.GET)
	public String hello3(@PathVariable String name, Model model) {

		String message = "<br><div align='center'>" + "<h3>3. Hello ** Welcome :"
				+ name + "</h3> </div> <br /> <br />";

		model.addAttribute("strvalue", message);
		return "plaintext";
	}

}
