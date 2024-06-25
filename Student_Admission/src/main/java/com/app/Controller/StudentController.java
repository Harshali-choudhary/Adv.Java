package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.StudentService;
import com.app.entites.Student;



@RestController

public class StudentController {

	@Autowired
	private StudentService studentSer;
	
	@PostMapping("/students")
	public ResponseEntity<String> addNewStudent(@RequestBody Student s,@RequestParam Long course_id)
	{
		String response = studentSer.addNewStudent(s, course_id); 
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/students/coures_title/{title}")
	public ResponseEntity<List<Student>> getStudentByCourseTitle(@PathVariable String title)
	{
		List<Student> Slist=studentSer.getByCourseTitle(title);
		return ResponseEntity.ok(Slist);
	}
	
	@DeleteMapping("/courses/{courseId}/students/{studentId}")
	public ResponseEntity<String> cancelAdmission(@PathVariable Long courseId,@PathVariable Long studentId)
	{
		String response=studentSer.deleteStudent(studentId, courseId);
		return ResponseEntity.ok(response);
	}
}
