package com.seniorsteps.app.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ENROLLMENT")
public class Enrollment {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ENROL_DATE")
	private LocalDateTime enrolDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COURSE_ID")
	private Course course;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	public Enrollment() {}
	
	public Enrollment(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDateTime getEnrolDate() {
		return enrolDate;
	}
	public void setEnrolDate(LocalDateTime enrolDate) {
		this.enrolDate = enrolDate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
		
}
