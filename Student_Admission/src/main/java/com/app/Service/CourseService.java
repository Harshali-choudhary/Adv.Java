package com.app.Service;

import com.app.entites.Course;
import com.app.entites.Student;

public interface CourseService {

	Course addNewCourse(Course newCourse);
	
	boolean UpdateFees(Long courseId,double fees);
	
}
