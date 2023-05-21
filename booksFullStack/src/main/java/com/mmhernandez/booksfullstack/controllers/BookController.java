package com.mmhernandez.booksfullstack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mmhernandez.booksfullstack.models.Book;
import com.mmhernandez.booksfullstack.services.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public String booksList() {
		return "bookList.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String book(
			Model model, 
			@PathVariable("id") Long id) {
		Book book = bookService.getBook(id);
		model.addAttribute(book);
		return "book.jsp";
	}
	
}
