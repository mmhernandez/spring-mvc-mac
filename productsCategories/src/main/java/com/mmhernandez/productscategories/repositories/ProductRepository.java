package com.mmhernandez.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.productscategories.models.Category;
import com.mmhernandez.productscategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findAll();
	List<Product> findAllByOrderByName();
	
    List<Product> findAllByCategories(Category category);
    List<Product> findByCategoriesNotContains(Category category);

}
