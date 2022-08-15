package com.example.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.LoginUser;
import com.example.demo.models.User;
import com.example.demo.services.BookService;
import com.example.demo.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userServ;
	@Autowired
	private BookService bookServ;
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("uuid") !=null) {
			return "redirect:dashboard";
		}
//		binding empty user and loginuser objects to the jsp to capture the form input
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		
		User user = userServ.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("uuid", user.getId());
		
		return "redirect:/welcome";
		
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		
		User user = userServ.login(newLogin, result);
		
		if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "index.jsp";
	    }
		
		session.setAttribute("uuid", user.getId());
		
		return "redirect:/welcome";
		
	}
	
	@GetMapping("/welcome")
	public String welcome(HttpSession session, Model model) {
	 
		// If no userId is found, redirect to logout
		if(session.getAttribute("uuid") == null) {
			return "redirect:/logout";
		}
		
		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("uuid");
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("allBooks", bookServ.getAll());
		model.addAttribute("allUsers", userServ.getAll());
		
	    return "welcome.jsp";
	    
	}
	    
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uuid");
		
		return "redirect:/";
	}
	
	
	
	
}
