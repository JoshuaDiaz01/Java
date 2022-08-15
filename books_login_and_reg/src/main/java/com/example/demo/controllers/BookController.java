package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.services.BookService;
import com.example.demo.services.UserService;

@Controller
public class BookController {

	@Autowired
	private BookService bookServ;
	
	@Autowired 
	private UserService userServ;
	
	
//	display
	@GetMapping("/books")
	public String allBooks(@ModelAttribute("newBook") Book newBook, Model model) {
		model.addAttribute("allBooks", bookServ.getAll());
		model.addAttribute("allUsers", userServ.getAll());
		return "books.jsp";
	}
	
//	action
	
	@PostMapping("/books/create")
	public String createBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("allBooks", bookServ.getAll());
			model.addAttribute("allUsers", userServ.getAll());
			return "books.jsp";
		}
		//setting user to whoever is logged in
		Long userId = (Long) session.getAttribute("uuid");
		User user = userServ.findById(userId);
		newBook.setUser(user);
		
		bookServ.save(newBook);  
		return "redirect:/books";
	}
	
	@GetMapping("/books/{bookId}")
	public String show(Model model, @PathVariable("bookId") Long bookId) {
		System.out.println(bookId);
		Book book = bookServ.findBook(bookId);
		System.out.println(book);
		
//		making array of books for the for loop
		List<Book> books = bookServ.allBooks();
		
		model.addAttribute("book", book);
		model.addAttribute("books", books);

		
		return "show.jsp";
	}
	
	
}
