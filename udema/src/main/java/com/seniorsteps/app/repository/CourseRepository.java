package com.seniorsteps.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seniorsteps.app.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	
}
