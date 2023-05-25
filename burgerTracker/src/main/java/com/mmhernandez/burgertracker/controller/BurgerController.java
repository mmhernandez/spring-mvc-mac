package com.mmhernandez.burgertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mmhernandez.burgertracker.models.Burger;
import com.mmhernandez.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/")
	public String burgerTracker(Model model) {
		List<Burger> burgerList = burgerService.getAll();
		model.addAttribute(burgerList);
		
		return "burgerTracker.jsp";
	}
	
	@PostMapping("/burger/add")
	public String createBurger(
			@Valid @ModelAttribute("newBurger") Burger burger,
			BindingResult result) {
		if(result.hasErrors()) {
			return "burgerTracker.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/";
	}
	
	
	
}
