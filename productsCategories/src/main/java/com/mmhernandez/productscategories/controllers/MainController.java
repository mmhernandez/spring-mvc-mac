package com.mmhernandez.productscategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mmhernandez.productscategories.models.Category;
import com.mmhernandez.productscategories.models.Product;
import com.mmhernandez.productscategories.services.CategoryService;
import com.mmhernandez.productscategories.services.ProductService;

import jakarta.validation.Valid;

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
	
	@GetMapping("/products/new")
	public String newProduct(
			@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(
			@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	
	
	@PostMapping("/products/new")
	public String addProduct(
			@Valid @ModelAttribute("product") Product product,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		productService.create(product);
		return "redirect:/";
	}
	
	@PostMapping("/categories/new")
	public String addProduct(
			@Valid @ModelAttribute("category") Category category,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		categoryService.create(category);
		return "redirect:/";
	}
	
}
