package com.app.Service;

import java.util.List;

import com.app.entites.Student;

public interface StudentService {

	String addNewStudent(Student newStudent,Long courseId);
	
	List<Student> getByCourseTitle(String title);
	
	String deleteStudent(Long studentId,Long courseId);
}
