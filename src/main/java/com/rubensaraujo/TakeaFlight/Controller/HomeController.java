package com.rubensaraujo.TakeaFlight.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
 
	@GetMapping(value = {"/home", "/"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/home");
		return mv;
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
