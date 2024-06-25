package com.app.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Repository.StudentRepository;
import com.app.entites.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepo;

	public String addNewStudent(Student newStudent,Long courseId) {
		
		if(newStudent.getScoreObtained() >= newStudent.getCourse().getMin_Score())
		{
			studentRepo.save(newStudent);
			return "Admission granted";
		}
		else {
			return "Admission denied";
		}
	}

	@Override
	public List<Student> getByCourseTitle(String title) {
	
		return studentRepo.findByCourse_Title(title);
	}

	@Override
	public String deleteStudent(Long studentId, Long courseId) {
		
		Optional< Student> optionalStudent=studentRepo.findById(studentId);
		if(optionalStudent.isPresent())
		{
			Student s= optionalStudent.get();
			if(s.getCourse().getCourseId().equals(courseId))
			{
				studentRepo.delete(s);
				return "Student admission canceled successfully";
			}
			else
				return "Student not enrolled in sepcified course";
		}
		return "Student not found";
	}
	
	

}
