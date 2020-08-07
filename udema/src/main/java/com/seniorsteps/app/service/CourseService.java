package com.seniorsteps.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public Page<Course> list(CourseFilter filter) {

		if(filter.getSize() == 0) filter.setSize(5);
		
		Page<Course> courses = courseRepository
				.findAll(filter, PageRequest.of(filter.getPage(),filter.getSize()));
		return courses;
	}

	public Course findById(int courseId) {
		return courseRepository.findCourseById(courseId);
	}

}
