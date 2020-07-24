package com.seniorsteps.app.models;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COURSE_STATISTICS")
public class CourseStatistics implements Serializable {

	

	private static final long serialVersionUID = -8690163259001546668L;

	@Id
	@OneToOne
	@JoinColumn(name="ID")
	private Course course;
	
	@Column(name="ENROLLMENT_COUNT")
	private Integer enrollmentCount;
	
	@Column(name="REVIEW_COUNT")
	private Integer reviewCount;
	
	@Column(name="REVIEW_RATE")
	private Double reviewRate;
	
	@Column(name="CONTENT_COUNT")
	private Integer contentCount;
	
	@Column(name="CONTENT_TOTAL_TIME")
	private LocalTime contentTotalTime;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getEnrollmentCount() {
		return enrollmentCount;
	}

	public void setEnrollmentCount(Integer enrollmentCount) {
		this.enrollmentCount = enrollmentCount;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public Double getReviewRate() {
		return reviewRate;
	}

	public void setReviewRate(Double reviewRate) {
		this.reviewRate = reviewRate;
	}

	public Integer getContentCount() {
		return contentCount;
	}

	public void setContentCount(Integer contentCount) {
		this.contentCount = contentCount;
	}

	public LocalTime getContentTotalTime() {
		return contentTotalTime;
	}

	public void setContentTotalTime(LocalTime contentTotalTime) {
		this.contentTotalTime = contentTotalTime;
	}
	
	
}
