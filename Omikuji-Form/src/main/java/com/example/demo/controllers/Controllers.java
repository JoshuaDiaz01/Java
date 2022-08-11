package com.example.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {
	@GetMapping("/")
	public String idex() {
		return "index.jsp";
	}
	

	@PostMapping("/submit")
	public String submitForm(
		@RequestParam(value = "number") String number,
		@RequestParam(value = "city") String city,
		@RequestParam(value = "name") String name,
		@RequestParam(value = "hobby") String hobby,
		@RequestParam(value = "animal") String animal,
		@RequestParam(value = "comment") String comment,
		HttpSession session
	){
	session.setAttribute("number", number);
	session.setAttribute("city", city);
	session.setAttribute("name", name);
	session.setAttribute("hobby", hobby);
	session.setAttribute("animal", animal);
	session.setAttribute("comment", comment);
	
	return "redirect:/display";
	}
	
@GetMapping ("/display")
public String display(HttpSession session, Model model) {
	model.addAttribute("number", session.getAttribute("number"));
	model.addAttribute("city", session.getAttribute("city"));
	model.addAttribute("name", session.getAttribute("name"));
	model.addAttribute("hobby", session.getAttribute("hobby"));
	model.addAttribute("animal", session.getAttribute("animal"));
	model.addAttribute("comment", session.getAttribute("comment"));
	
	
	return "results.jsp";
}
	
}
