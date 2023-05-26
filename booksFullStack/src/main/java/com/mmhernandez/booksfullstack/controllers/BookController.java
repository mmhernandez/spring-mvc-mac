package com.mmhernandez.booksfullstack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mmhernandez.booksfullstack.models.Book;
import com.mmhernandez.booksfullstack.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public String booksList(Model model) {
		List<Book> bookList = bookService.getAll();
		model.addAttribute(bookList);
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
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("newBook") Book book) {
		return "newBook.jsp";
	}
	
	@PostMapping("/books")
	public String insertBook(
			@Valid @ModelAttribute("newBook") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		bookService.createBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}/edit")
    public String edit(
	    		@PathVariable("id") Long id, 
	    		Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "editBook.jsp";
    }
    
    @PutMapping("/books/{id}")
    public String update(
	    		@Valid @ModelAttribute("book") Book book, 
	    		BindingResult result, 
	    		Model model) {
        if (result.hasErrors()) {
            model.addAttribute("book", book);
            return "editBook.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
	
}
