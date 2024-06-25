package com.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.CourseService;
import com.app.entites.Course;
import com.app.entites.Student;



@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseSer;
	
	@PostMapping
	public ResponseEntity<String> addNewCourse(@RequestBody Course c)
	{
		System.out.println("in course add");
		Course newcourse= courseSer.addNewCourse(c);
		return ResponseEntity.ok("Course created with ID : "+newcourse);
	}
	
	@PutMapping("/courses/{courseId}/Fees/{updatedfees}")
	public ResponseEntity<String> updateFees(@PathVariable Long courseId,@PathVariable double updatedfees)
	{
		System.out.println("in update fees");
		boolean b=courseSer.UpdateFees(courseId,updatedfees);
		return ResponseEntity.ok("Fees updated successfully : "+updatedfees);
		
	}
}

