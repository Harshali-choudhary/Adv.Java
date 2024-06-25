package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entites.Course;
import com.app.entites.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
	
	
	
}
