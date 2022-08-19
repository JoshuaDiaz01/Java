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

import com.example.demo.models.Course;
import com.example.demo.models.User;
import com.example.demo.services.CourseService;
import com.example.demo.services.UserService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseServ;
	
	@Autowired 
	private UserService userServ;
	
	
//	display
	@GetMapping("/courses")
	public String allCourses(@ModelAttribute("newCourse") Course newCourse, Model model) {
		model.addAttribute("allCourses", courseServ.getAll());
		model.addAttribute("allUsers", userServ.getAll());
		return "courses.jsp";
	}
	
//	action
	
	@PostMapping("/courses/create")
	public String createCourse(@Valid @ModelAttribute("newCourse") Course newCourse, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("allCourses", courseServ.getAll());
			model.addAttribute("allUsers", userServ.getAll());
			return "courses.jsp";
		}
		//setting user to whoever is logged in
		Long userId = (Long) session.getAttribute("uuid");
		User user = userServ.findById(userId);
		newCourse.setUser(user);
		
		courseServ.save(newCourse);  
		return "redirect:/courses";
	}
	
	@GetMapping("/courses/{courseId}")
	public String show(Model model, @PathVariable("courseId") Long courseId, HttpSession session) {
		System.out.println(courseId);
		Course course = courseServ.findCourse(courseId);
		System.out.println(course);
		
//		implementing user so the jsp page can have access to user
		Long userId = (Long) session.getAttribute("uuid");
		User user = userServ.findById(userId);
//		making array of books for the for loop
		List<Course> courses = courseServ.allCourses();
		
		model.addAttribute("course", course);
		model.addAttribute("user", user);

		
		return "show.jsp";
	}
	
	@GetMapping("/courses/{courseId}/edit")
	public String editCourse(HttpSession session, Model model, @PathVariable("courseId")Long courseId) {

		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}	

		
		//allows for conditional rendering c:if
		Course course = courseServ.getOne(courseId);
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		if (course.getUser().getId() != user.getId()) {
			return "redirect:/welcome";
		}
		model.addAttribute("user", user);
		model.addAttribute("course", courseServ.getOne(courseId));
		
		return "editCourse.jsp";
		
	}
	
	@PutMapping("/courses/{id}/update")
	public String updateCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, HttpSession session, @PathVariable("id")Long courseId) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}	
		// recreating relationship from user to book, and validating user for conditional rendering
		Course courseFromDb = courseServ.getOne(courseId);
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		if (courseFromDb.getUser().getId() != user.getId()) {
			return "redirect:/welcome";
		}
		if (result.hasErrors()) {
			return "editCourse.jsp";
		}
		

		course.setUser(user);
		
		courseServ.save(course);
		
		return "redirect:/courses/" + courseId;
		
	}
		
		
	@DeleteMapping("/course/{id}/delete")
	public String deleteCourse(HttpSession session, @PathVariable("id")Long id) {
		if(session.getAttribute("uuid") == null) {
			
			return "redirect:/";
	}
	
		courseServ.delete(id);
		return "redirect:/courses";
	
	}

}
