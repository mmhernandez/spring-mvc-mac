package com.mmhernandez.burgertracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mmhernandez.burgertracker.services.BurgerService;

@Controller
public class BurgerController {

	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/")
	public String burgerTracker() {
		return "burgerTracker.jsp";
	}
	
	
	
}
