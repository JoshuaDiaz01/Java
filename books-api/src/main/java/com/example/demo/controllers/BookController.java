package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import com.example.demo.models.Book;
import com.example.demo.services.BookService;

@Controller
public class BookController {
	
	//does dependency injection
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String home(Model model) {
		return "redirect:books";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	

	@GetMapping("/books/{bookId}")
	public String show(Model model, @PathVariable("bookId") Long bookId) {
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
//		making array of books for the for loop
		List<Book> books = bookService.allBooks();
		
		model.addAttribute("book", book);
		model.addAttribute("books", books);

		
		return "show.jsp";
	}
	
	
}
