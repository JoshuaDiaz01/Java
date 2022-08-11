package com.example.demo.controllers;

import java.util.List;

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

import com.example.demo.models.Dojo;
import com.example.demo.services.DojoService;


@Controller
public class DojoController {

	@Autowired
	private DojoService dojoServ;
	

	
	// FULL CRUD example routes
//	/dogs
//	/dogs/new
//	/dogs/create
//	/dogs/{id}
//	/dogs/{id}/edit
//	/dogs/{id}/update
//	/dogs/{id}/delete
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos";
	}
	
//	display
	
	@GetMapping("/dojos")
	public String dojos(Model model) {
		List<Dojo> listOfDojos = dojoServ.getAll();
		model.addAttribute("dojos", listOfDojos);
		
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("newDojo") Dojo newDojo) {
		// creating an empty Dog object and passing it to the jsp page
		// if we were using Model model, the equivalent code would be
		// model.addAttribute("newDog", new Dog());
		
		return "newDojo.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String oneDojo(@PathVariable("id") Long id, Model model) {
//		Dog thisDog = dogServ.getOne(id);
//		model.addAttribute("dog", thisDog);
		
		model.addAttribute("dojo", dojoServ.getOne(id));
		
		
		return "oneDojo.jsp";
	}
	
	@GetMapping("/dojos/{id}/edit")
	public String editDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoServ.getOne(id));
		
		return "editDojo.jsp";
	}
	
	// ========== Action ========================
	
		@PostMapping("/dojos/create")
		public String createDojo(@Valid @ModelAttribute("newDojo") Dojo newDojo, BindingResult result) {
			// this newDog parameter is going to contain a Dog object with all the post data from the form
			if (result.hasErrors()) {
				return "newDojo.jsp";
			}
			
			dojoServ.save(newDojo);
			
			return "redirect:/dojos";
		}
		
		@PutMapping("/dojos/{id}/update")
		public String updateDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, @PathVariable("id") Long dojoId) {
			if (result.hasErrors()) {
				return "editDojo.jsp";
			}
			System.out.println("The dojo id in the model attribute is:" + dojo.getId());
			
//			dog.setId(dogId);
			dojoServ.save(dojo);
			
//			return "redirect:/dogs/" + id;
			return String.format("redirect:/dojos/%d", dojoId);
		}
		
		@DeleteMapping("/dojos/{id}/delete")
		public String deleteDojo(@PathVariable("id") Long id) {
			dojoServ.delete(id);
			
			return "redirect:/dojos";
		}
		
	
	
}
