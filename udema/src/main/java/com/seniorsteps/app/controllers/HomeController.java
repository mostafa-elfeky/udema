package com.seniorsteps.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seniorsteps.app.filters.CourseFilter;
import com.seniorsteps.app.models.Course;
import com.seniorsteps.app.models.Lookup;
import com.seniorsteps.app.models.enums.LookupType;
import com.seniorsteps.app.repository.LookupRepository;
import com.seniorsteps.app.service.CourseService;

@Controller
public class HomeController {

	@Autowired
	LookupRepository lookupRepository;
	
	@Autowired
	CourseService courseService;
	
	@GetMapping
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView("index");
		
		List<Lookup> categories = lookupRepository.findByType(LookupType.CATEGORY.getType());
		
		CourseFilter filter = new CourseFilter();
		filter.setListingType("LATEST");
		filter.setSize(5);
		
		List<Course> courses = courseService.list(filter).getContent();
		
		mav.addObject("categories", categories);
		mav.addObject("courses", courses);
		
		return mav;
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}
}
