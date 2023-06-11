package com.mmhernandez.productscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.productscategories.models.Category;
import com.mmhernandez.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
//	create
	public Category create(Category category) {
		return categoryRepo.save(category);
	}
	
//	get all
	public List<Category> getAll() {
		return categoryRepo.findAll();
	}
	
//	get all - order by name
	public List<Category> getAllOrderByName() {
		return categoryRepo.findAllByOrderByName();
	}
	
}
