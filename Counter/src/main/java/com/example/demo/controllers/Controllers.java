package com.example.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Controllers {
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
		}
		
		return "index.jsp";
	}
	
	
	@GetMapping("/counter/")
	public String counter(HttpSession session, Model model) {
		Integer currentCount = 0;
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
			currentCount = (Integer) session.getAttribute("count");
			
		}
		model.addAttribute("count", currentCount);
	
	return "counter.jsp";
	}
	
	@GetMapping("/reset-counter/")
	public String resetCounter(HttpSession session, Model model) {
		
		session.setAttribute("count", 0);

		return "redirect:/counter/";
	}
	
}



