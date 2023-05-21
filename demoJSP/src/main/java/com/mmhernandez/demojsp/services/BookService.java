package com.mmhernandez.demojsp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mmhernandez.demojsp.models.Book;
import com.mmhernandez.demojsp.repositories.BookRepository;

@Service
public class BookService {

//	DEPENDENCE INJECTION
	private final BookRepository bookRepository;
	
//	CONSTRUCTORS
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
//	OTHER METHODS
//	get all books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
//	get one book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
//	create a book
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
//	update a book
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
//	delete a book
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {			
			bookRepository.deleteById(id);
		}
	}
}
