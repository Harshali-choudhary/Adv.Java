package com.app.entites;


import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private Long courseId;
	@Column(unique = true)
	private String courseTitle;
	private Date startDate;
	private Date endDate;
	private double Fees;
	private double Min_Score;
	
	
	
	public Course() {
		
	}


	public Course(Long courseId, String courseTitle, Date startDate, Date endDate, double fees,
			double min_Score) {
		super();
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		Fees = fees;
		Min_Score = min_Score;
		
		
	}
	
	
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getFees() {
		return Fees;
	}
	public void setFees(double fees) {
		Fees = fees;
	}
	public double getMin_Score() {
		return Min_Score;
	}
	public void setMin_Score(double min_Score) {
		Min_Score = min_Score;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseTitle=" + courseTitle + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", Fees=" + Fees + ", Min_Score=" + Min_Score + "]";
	}
	
	
	
}
