package com.mmhernandez.demojsp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmhernandez.demojsp.models.Book;
import com.mmhernandez.demojsp.services.BookService;

@RestController
public class BooksAPI {
	
//	DEPENDENCE INJECTION
	private final BookService bookService;
	
//	CONTROLLER
	public BooksAPI(BookService bookService) {
		this.bookService = bookService;
	}
	
//	OTHER METHODS
	@RequestMapping("/api/books")
	public List<Book> getAllBooks() {
		return bookService.allBooks();
	}
	
	@RequestMapping("/api/books/{id}")
	public Book getOneBook(@PathVariable("id") Long id) {
		Book book =  bookService.findBook(id);
		return book;
	}
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book addBook(
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="numberOfPages") Integer numberOfPages) {
		Book book = new Book(title, description, language, numberOfPages);
		return bookService.createBook(book);
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	public Book updateBook(
			@PathVariable("id") Long id,
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="numberOfPages") Integer numberOfPages) {
		Book book = new Book(title, description, language, numberOfPages);
		book.setId(id);
		return bookService.updateBook(book);
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}

}
