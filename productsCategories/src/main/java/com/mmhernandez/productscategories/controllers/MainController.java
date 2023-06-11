package com.mmhernandez.productscategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mmhernandez.productscategories.services.CategoryService;
import com.mmhernandez.productscategories.services.ProductService;

@Controller
public class MainController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping("/")
	public String home(
			Model model) {
		model.addAttribute("products", productService.getAllOrderByName());
		model.addAttribute("categories", categoryService.getAllOrderByName());
		return "home.jsp";
	}
	
}
