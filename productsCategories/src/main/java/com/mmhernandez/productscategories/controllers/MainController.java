package com.mmhernandez.productscategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/products/{id}")
	public String productPage(
			@PathVariable("id") Long id,
			Model model) {
		Product prod = productService.getById(id);
		model.addAttribute("product", prod);
		model.addAttribute("categoryList", categoryService.getByProduct(prod));
		model.addAttribute("availableCategories", categoryService.getCategoriesNotContaining(prod));
		return "product.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(
			@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@GetMapping("/categories/{id}") 
	public String categoryPage(
			@PathVariable("id") Long id,
			Model model) {
		Category cat = categoryService.getById(id);
		model.addAttribute("category", cat);
		model.addAttribute("productList", productService.getProductsByCategory(cat));
		model.addAttribute("availableProducts", productService.getProductsNotContaining(cat));
		return "category.jsp";
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
	public String addCategory(
			@Valid @ModelAttribute("category") Category category,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		categoryService.create(category);
		return "redirect:/";
	}
	
	
	@PutMapping("/products/{id}/add/category")
	public String updateProductCategories(
			@RequestParam("category") Long categoryId,
			@PathVariable("id") Long productId) {
		Product prod = productService.getById(productId);
		Category cat = categoryService.getById(categoryId);
		prod.getCategories().add(cat);
		productService.update(prod);
		return "redirect:/products/" + productId;
	}
	
	@PutMapping("/categories/{id}/add/product")
	public String updateCategoryProducts(
			@RequestParam("product") Long productId,
			@PathVariable("id") Long categoryId) {
		Category cat = categoryService.getById(categoryId);
		Product prod = productService.getById(productId);
		cat.getProducts().add(prod);
		categoryService.update(cat);
		return "redirect:/categories/" + categoryId;
	}
	
}
