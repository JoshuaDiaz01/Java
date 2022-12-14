package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
	public String show(Model model, @PathVariable("bookId") Long bookId, HttpSession session) {
		System.out.println(bookId);
		Book book = bookServ.findBook(bookId);
		System.out.println(book);
		
//		implementing user so the jsp page can have access to user
		Long userId = (Long) session.getAttribute("uuid");
		User user = userServ.findById(userId);
//		making array of books for the for loop
		List<Book> books = bookServ.allBooks();
		
		model.addAttribute("book", book);
		model.addAttribute("user", user);

		
		return "show.jsp";
	}
	
	@GetMapping("/books/{bookId}/edit")
	public String editBook(HttpSession session, Model model, @PathVariable("bookId")Long bookId) {

		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}	

		
		//allows for conditional rendering c:if
		Book book = bookServ.getOne(bookId);
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		if (book.getUser().getId() != user.getId()) {
			return "redirect:/welcome";
		}
		model.addAttribute("user", user);
		model.addAttribute("book", bookServ.getOne(bookId));
		
		return "editBook.jsp";
		
	}
	
	@PutMapping("/books/{id}/update")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, @PathVariable("id")Long bookId) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}	
		// recreating relationship from user to book, and validating user for conditional rendering
		Book bookFromDb = bookServ.getOne(bookId);
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		if (bookFromDb.getUser().getId() != user.getId()) {
			return "redirect:/welcome";
		}
		if (result.hasErrors()) {
			return "redirect:editBook.jsp";
		}
		// recreating relationship from user to book

		book.setUser(user);
		
		bookServ.save(book);
		
		return "redirect:/books/" + bookId;
		
	}
		
		
	@DeleteMapping("/book/{id}/delete")
	public String deleteBook(HttpSession session, @PathVariable("id")Long id) {
		if(session.getAttribute("uuid") == null) {
			
			
			return "redirect:/";
	}
	
		bookServ.delete(id);
		return "redirect:/books";
	
	}

}
