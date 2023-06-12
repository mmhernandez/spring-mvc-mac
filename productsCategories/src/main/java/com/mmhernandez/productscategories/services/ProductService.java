package com.mmhernandez.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.productscategories.models.Category;
import com.mmhernandez.productscategories.models.Product;
import com.mmhernandez.productscategories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
//	create
	public Product create(Product product) {
		return productRepo.save(product);
	}
	
//	update
	public Product update(Product product) {
		return productRepo.save(product);
	}
	
//	get all
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
//	get all - order by name
	public List<Product> getAllOrderByName() {
		return productRepo.findAllByOrderByName();
	}
	
//	get one - by id
	public Product getById(Long id) {
		Optional<Product> oProduct = productRepo.findById(id);
		if(oProduct.isPresent()) {
			return oProduct.get();
		}
		return null;
	}
	
//	get product list by category
	public List<Product> getProductsByCategory(Category category) {
		return productRepo.findAllByCategories(category);
	}
	
//	get products not associated to a category
	public List<Product> getProductsNotContaining(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
	
	
	
}
