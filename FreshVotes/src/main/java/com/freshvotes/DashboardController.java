package com.freshvotes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String rootView() {
		
		// it will return html file called index.html
		// root page of our application
		
		return "index";
	}
	
	
}
