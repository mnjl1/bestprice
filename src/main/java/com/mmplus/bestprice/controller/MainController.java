package com.mmplus.bestprice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	

	@RequestMapping("/")
	public String welcome() {
		return "welcome-page";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
}
