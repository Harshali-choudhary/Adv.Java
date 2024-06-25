package com.app.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="students")

public class Student {
	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private Long Student_id;
	private String first_name;
	private String last_name;
	private String email;
	private double scoreObtained;
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	
	
	public Student() {
		
	}
	public Student(Long student_id, String first_name, String last_name, String email, double scoreObtained,
			Course course) {
		super();
		Student_id = student_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.scoreObtained = scoreObtained;
		this.course = course;
	}
	public Long getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(Long student_id) {
		Student_id = student_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getScoreObtained() {
		return scoreObtained;
	}
	public void setScoreObtained(double scoreObtained) {
		this.scoreObtained = scoreObtained;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [Student_id=" + Student_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", scoreObtained=" + scoreObtained + ", course=" + course + "]";
	}
	
	
	
	
}
