package com.mmhernandez.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.productscategories.models.Category;
import com.mmhernandez.productscategories.models.Product;
import com.mmhernandez.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
//	create
	public Category create(Category category) {
		return categoryRepo.save(category);
	}
	
//	update
	public Category update(Category category) {
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
	
//	get category list by product
	public List<Category> getByProduct(Product product) {
		return categoryRepo.findAllByProducts(product);
	}
	
//	get category list not associated with the product
	public List<Category> getCategoriesNotContaining(Product product) {
		return categoryRepo.findByProductsNotContains(product);
	}
	
//	get one - by id
	public Category getById(Long id) {
		Optional<Category> oCategory = categoryRepo.findById(id);
		if(oCategory.isPresent()) {
			return oCategory.get();
		}
		return null;
	}
	
}
