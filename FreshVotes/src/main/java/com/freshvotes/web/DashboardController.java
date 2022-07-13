package com.freshvotes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DashboardController {
	
	@GetMapping("/")
	public String rootView() {
		
		// it will return html file called index.html
		// root page of our application
		
		return "index";
	}
	
	
}
