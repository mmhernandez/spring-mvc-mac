package com.mmhernandez.booksfullstack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.booksfullstack.models.Book;
import com.mmhernandez.booksfullstack.repositories.BookRepository;

@Service
public class BookService {

//	DEPENDENCY INJECTION
	@Autowired
	BookRepository bookRepository;
	
//	CONSTRUCTOR
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
//	OTHER METHODS
//	get all books
	public List<Book> getAll() {
		return bookRepository.findAll();
	}
	
//	get book
	public Book getBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
//	create book
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
//	update book
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
//	delete book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
}
