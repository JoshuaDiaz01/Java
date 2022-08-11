package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Item;



@Controller
public class ItemController {

	
	@RequestMapping("/")
	public String index(Model model) {
		
        ArrayList<Item> fruits = new ArrayList<Item>();
        fruits.add(new Item("Kiwi", 1.5));
        fruits.add(new Item("Mango", 2.0));
        fruits.add(new Item("Goji Berries", 4.0));
        fruits.add(new Item("Guava", .75));
        
        // Add fruits your view model
        
//        model.addAttribute("name", "Kiwi");
//        model.addAttribute("price", 1.5);
//        model.addAttribute("name", "Mango");
//        model.addAttribute("price", 2.0);
//        model.addAttribute("name", "Goji Berries");
//        model.addAttribute("price", 4.0);
//        model.addAttribute("name", "Guava");
//        model.addAttribute("price", .75);
        model.addAttribute("fruits", fruits);
      
        
        	
      
		return "loops.jsp";
	}
}
