package com.mmhernandez.dojoninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mmhernandez.dojoninjas.models.Dojo;
import com.mmhernandez.dojoninjas.models.Ninja;
import com.mmhernandez.dojoninjas.services.DojoService;
import com.mmhernandez.dojoninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	
	@GetMapping("/")
	public String home() {
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos")
	public String dojos(Model model) {
		model.addAttribute("dojos", dojoService.getAll());
		return "dojoList.jsp";
	}
	
	@GetMapping("/dojo/new")
	public String newDojo(
			@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@GetMapping("/ninja/new")
	public String newNinja(
			@ModelAttribute("ninja") Ninja ninja,
			Model model) {
		model.addAttribute("dojos", dojoService.getAll());
		return "newNinja.jsp";
	}
	
	@GetMapping("/dojo/{dojoId}")
	public String dojoNinjas(
			Model model,
			@PathVariable("dojoId") Long id) {
		model.addAttribute("dojo", dojoService.getById(id));
		model.addAttribute("ninjas", ninjaService.getByDojoId(id));
		return "dojoNinjas.jsp";
	}
	
	
	
	@PostMapping("/dojo/create")
	public String createDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.getAll());
			return "newDojo.jsp";
		}
		dojoService.createDojo(dojo);
		return "redirect:/";
	}
	
	@PostMapping("/ninja/create")
	public String createNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/";
	}

}
