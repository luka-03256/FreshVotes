package com.freshvotes.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DashboardController {
	

	
	
	// @RequestMapping annotation same as @GetMapping
	//@RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping("/")
	public String rootView() {
		
		// it will return html file called index.html
		// root page of our application
		
		return "index";
	}
	
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
	
}
