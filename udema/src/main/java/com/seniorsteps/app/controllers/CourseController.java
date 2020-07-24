package com.seniorsteps.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seniorsteps.app.filters.CourseFilter;
import com.seniorsteps.app.models.Course;
import com.seniorsteps.app.models.Lookup;
import com.seniorsteps.app.models.enums.LookupType;
import com.seniorsteps.app.repository.CourseRepository;
import com.seniorsteps.app.repository.LookupRepository;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	LookupRepository lookupRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping
	public ModelAndView list(CourseFilter filter) {
		
		ModelAndView mav = new ModelAndView("course/course-list");
		
		List<Course> courses = courseRepository.findAll();
		List<Lookup> categories = lookupRepository.findByType(LookupType.CATEGORY.getType());
		
		mav.addObject("categories", categories);
		mav.addObject("courses", courses);
		
		return mav;
	}
	
}
