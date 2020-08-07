package com.seniorsteps.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.seniorsteps.app.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>, 
		JpaSpecificationExecutor<Course> {

	@Override
	@EntityGraph(value="Course.Basic", type=EntityGraphType.FETCH)
	List<Course> findAll(Specification<Course> spec);
	
	
	@EntityGraph(value="Course.Details", type=EntityGraphType.FETCH)
	Course findCourseById(Integer id);
}
