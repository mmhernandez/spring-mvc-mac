package com.mmhernandez.demojsp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.demojsp.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

//	GET ALL BOOKS
	List<Book> findAll();
	
//	GET BOOKS BY DESC USING SEARCH STRING
	List<Book> findByDescriptionContaining(String search);
	
//	GET COUNT OF BOOKS BY TITLE USING SEARCH STRING
	Long countByTitleContaining(String search);
	
//	DELETE BOOKS WITH MATCHING TITLE STARTS WITH SEARCH STRING
	Long deleteByTitleContaining(String search);
	
}
