package com.mmhernandez.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.safetravels.models.Expense;
import com.mmhernandez.safetravels.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired 
	ExpenseRepository expenseRepository;
	
//	CONSTRUCTOR
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
//	get by id
	public Expense getById(Long id) {
		Optional<Expense> optExp = expenseRepository.findById(id);
		if(optExp.isPresent()) {
			return optExp.get();
		} else {
			return null;
		}
	}
	
//	get all expenses
	public List<Expense> getAll() {
		return expenseRepository.findAll();
	}
	
//	create an expense
	public Expense insert(Expense expense) {
		return expenseRepository.save(expense);
	}
	
//	update an expense
	public Expense update(Expense expense) {
		return expenseRepository.save(expense);
	}
	
//	delete an expense
	public void deleteById(Long id) {
		expenseRepository.deleteById(id);
	}
	
}
