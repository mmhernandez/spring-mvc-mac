package com.mmhernandez.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmhernandez.bookclub.models.Book;
import com.mmhernandez.bookclub.models.User;
import com.mmhernandez.bookclub.services.BookService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	
	@GetMapping("/books/add")
	public String newBook(
			@ModelAttribute("book") Book book,
			HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		return "newBook.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String viewBook(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		model.addAttribute("book", bookService.getById(id));
		model.addAttribute("user", session.getAttribute("user"));
		return "viewBook.jsp";
	}
	
	@GetMapping("/books/edit/{id}")
	public String editBook(
			@PathVariable("id") Long id,
			@ModelAttribute("book") Book book,
			Model model,
			HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		model.addAttribute("book", bookService.getById(id));
		return "editBook.jsp";
	}
	
	@GetMapping("/books/borrow/{id}")
	public String borrowBook(
			@PathVariable("id") Long id,
			HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		
		// set function variables
		User user = (User) session.getAttribute("user");
		Book book = bookService.getById(id);
		
		// update book's borrower field with user
		book.setBorrower(user);
		bookService.update(book);
		
		return "redirect:/books";
	}
	
	@GetMapping("/books/return/{id}")
	public String returnBook(
			@PathVariable("id") Long id,
			HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		
		// set function variables
		Book book = bookService.getById(id);
		
		// update book's borrower field with user
		book.setBorrower(null);
		bookService.update(book);
		
		return "redirect:/books";
	}
	
	
	
	@PostMapping("/books/add")
	public String addBook(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		bookService.create(book);
		return "redirect:/books";
	}
	
	
	
	@PutMapping("/books/edit")
	public String updateBook(
			@RequestParam("id") Long id,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		bookService.update(book);
		return "redirect:/books/" + id;
	}
	
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(
			@PathVariable("id") Long id) {
		bookService.delete(id);
		return "redirect:/books";
	}
	
}