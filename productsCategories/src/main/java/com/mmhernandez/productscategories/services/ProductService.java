package com.mmhernandez.productscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
//	get all
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
//	get all - order by name
	public List<Product> getAllOrderByName() {
		return productRepo.findAllByOrderByName();
	}
	
}
