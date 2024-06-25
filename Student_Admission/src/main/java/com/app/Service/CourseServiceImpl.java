package com.app.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Repository.CourseRepository;
import com.app.entites.Course;
import com.app.entites.Student;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public Course addNewCourse(Course newCourse) {
		return courseRepo.save(newCourse);
	}

	@Override
	public boolean UpdateFees(Long courseId, double fees) {
		Course c=courseRepo.findById(courseId).orElse(null);
		if(c!=null)
		{
			c.setFees(fees);
			courseRepo.save(c);
			return true;
		}
		return false;
	}
	

}
