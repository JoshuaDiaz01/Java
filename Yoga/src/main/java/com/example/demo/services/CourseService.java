package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Course;
import com.example.demo.repositories.CourseRepository;

@Service 
public class CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	// ========== Create / Update ===============

	public Course save(Course course) {
		return courseRepo.save(course);
	}

	// ========== Read ==========================

	public List<Course> getAll() {
		return courseRepo.findAll();
	}
	
	// Main written out version of getOne()
//	public Toy getOne(Long id) {
//		Optional<Toy> toy = toyRepo.findById(id);
//		
//		if (toy.isPresent()) {
//			return toy.get();
//		} else {
//			return null;
//		}
//	}
	
	// Shorthand version
	public Course getOne(Long id) {
		return courseRepo.findById(id).orElse(null);
	}
	
	// retrieves a course
    public Course findCourse(Long id) {
        Optional<Course> optionalCourse = courseRepo.findById(id);
        if(optionalCourse.isPresent()) {
            return optionalCourse.get();
        } else {
            return null;
            }
    }
    
	// returns all the courses
    public List<Course> allCourses() {
        return courseRepo.findAll();
    }

	// ========== Delete ========================
	
	public void delete(Long id) {
		courseRepo.deleteById(id);
	}

	
}
