package com.seniorsteps.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seniorsteps.app.filters.CourseFilter;
import com.seniorsteps.app.models.Course;
import com.seniorsteps.app.repository.CourseRepository;
import com.seniorsteps.app.repository.LookupRepository;

@Service
public class CourseService {

	@Autowired
	LookupRepository lookupRepository;

	@Autowired
	CourseRepository courseRepository;

	public List<Course> list(CourseFilter filter) {

		List<Course> courses = courseRepository.findAll(filter);

		return courses;
	}

	public Course findById(int courseId) {
		return courseRepository.findById(courseId).get();
	}

}
