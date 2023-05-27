package com.mmhernandez.burgertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mmhernandez.burgertracker.models.Burger;
import com.mmhernandez.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/")
	public String burgerTracker(
			Model model,
			@ModelAttribute("newBurger") Burger burger) {
		List<Burger> burgerList = burgerService.getAll();
		model.addAttribute(burgerList);
		
		return "burgerTracker.jsp";
	}
	
	@PostMapping("/burger/add")
	public String createBurger(
			Model model,
			@Valid @ModelAttribute("newBurger") Burger burger,
			BindingResult result) {
		if(result.hasErrors()) {
			List<Burger> burgerList = burgerService.getAll()	;
			model.addAttribute(burgerList);
			return "burgerTracker.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/";
	}
	
	@GetMapping("/burger/{id}/edit")
	public String editBurger(
			@PathVariable("id") Long id,
			Model model) {
		Burger burger = burgerService.getById(id);
		model.addAttribute(burger);
		return "burgerEdit.jsp";
	}
	
	@PutMapping("/burger/{id}")
	public String updateBurger(
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "burgerEdit.jsp";
		} else {
			burgerService.updateBurger(burger);			
			return "redirect:/";
		}
	}
	
}
