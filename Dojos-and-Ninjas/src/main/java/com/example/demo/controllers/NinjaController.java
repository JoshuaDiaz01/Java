package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Ninja;
import com.example.demo.services.DojoService;
import com.example.demo.services.NinjaService;

@Controller
@RequestMapping("/")
public class NinjaController {

	@Autowired
	private NinjaService ninjaServ;
	
	@Autowired 
	private DojoService dojoServ;
	
	
//	display
	@GetMapping("/ninjas")
	public String allNinjas(@ModelAttribute("newNinja") Ninja newNinja, Model model) {
		model.addAttribute("allNinjas", ninjaServ.getAll());
		model.addAttribute("allDojos", dojoServ.getAll());
		return "ninjas.jsp";
	}
	
//	action
	
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allNinjas", ninjaServ.getAll());
			model.addAttribute("allDojos", dojoServ.getAll());
			return "ninjas.jsp";
		}
		ninjaServ.save(newNinja);  
		return "redirect:/ninjas";
	}
	
}
