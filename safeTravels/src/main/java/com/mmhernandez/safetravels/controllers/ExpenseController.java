package com.mmhernandez.safetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mmhernandez.safetravels.models.Expense;
import com.mmhernandez.safetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/") 
	public String expenseTable(Model model) {
		List<Expense> expenseList = expenseService.getAll();
		model.addAttribute(expenseList);
		return "expenses.jsp";
	}
	
	@GetMapping("/expense")
	public String addExpense(
			@ModelAttribute("expense") Expense expense) {
		return "newExpense.jsp";
	}
	
	@PostMapping("/expense") 
	public String insertExpense(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newExpense.jsp";
		} else {
			expenseService.insert(expense);
			return "redirect:/";
		}
	}
}
