package com.mmhernandez.burgertracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.burgertracker.models.Burger;
import com.mmhernandez.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {

	@Autowired
	BurgerRepository burgerRepository;
	
//	CONSTRUCTOR
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
//	OTHER METHODS
//	get all burger
	public List<Burger> getAll() {
		return burgerRepository.findAll();
	}
	
//	create burger
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
}
