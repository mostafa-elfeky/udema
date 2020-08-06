package com.seniorsteps.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seniorsteps.app.filters.CourseFilter;
import com.seniorsteps.app.models.Course;
import com.seniorsteps.app.models.Lookup;
import com.seniorsteps.app.models.enums.LookupType;
import com.seniorsteps.app.repository.LookupRepository;
import com.seniorsteps.app.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	LookupRepository lookupRepository;
	
	@GetMapping
	public ModelAndView list(CourseFilter filter) {
		
		ModelAndView mav = new ModelAndView("course/course-list");
		
		List<Course> courses = courseService.list(filter);
		List<Lookup> categories = lookupRepository.findByType(LookupType.CATEGORY.getType());
		
		mav.addObject("categories", categories);
		mav.addObject("courses", courses);
		mav.addObject("filter", filter);
		
		return mav;
	}
	
	@GetMapping("/{courseId}")
	public ModelAndView details(@PathVariable("courseId") int courseId) {
		
		ModelAndView mav = new ModelAndView("course/course-detail");
		
		Course course = courseService.findById(courseId);
		
		mav.addObject("course", course);
		return mav;
	} 
	
}
