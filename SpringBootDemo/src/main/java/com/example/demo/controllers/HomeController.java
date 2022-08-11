package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; //command shift o



@RestController
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "Hello There";
	}
	
	@RequestMapping("/daikichi/")
	public String daikichi() {
		return "Hello There";
	}
	
	
	
	//path variable allows for 
	@RequestMapping("/daikichi/{number}")
	public String pizza(@PathVariable("number") int number) {
		return "I like pizza " + number;
	}
	
//	@RequestMapping("/daikichi/{number}")
//	public String lotto(@PathVariable("number") int number) {
//		return "I like pizza " + number;
//	}
//	
//	@RequestMapping("/daikichi/{number}")
//	public String biglotto(@PathVariable("number") int number) {
//		return "I like pizza " + number;
//	}
//    @RequestMapping("/")
//    public String index(@RequestParam(value="q", required=false) String searchQuery) {
//    	if (searchQuery == null) {
//    		return "You searched or nothing";
//    	}
//    	else{return "You searched for: " + searchQuery;
//    }
	
//    @RequestMapping("/")
//    public String index(@RequestParam(value="name", required=false) String searchQuery) {
//    	if (searchQuery == null) {
//    		return "You searched or nothing";
//    	}
//    	else{	return "Hello " + searchQuery;
//    	}
//
//		
//    	}
//    
    
    
    }

