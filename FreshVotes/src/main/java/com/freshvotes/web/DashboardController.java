package com.freshvotes.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DashboardController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
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
