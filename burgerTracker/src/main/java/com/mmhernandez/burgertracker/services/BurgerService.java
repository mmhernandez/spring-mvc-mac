package com.mmhernandez.burgertracker.services;

import java.util.List;
import java.util.Optional;

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
//	get all burgers
	public List<Burger> getAll() {
		return burgerRepository.findAll();
	}
	
//	get one burger
	public Burger getById(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		} else {
			return null;
		}
	}
	
//	create burger
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
//	update burger
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
}
