package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.repository.StudentRepository;
@RestController
public class StudentController {
	private StudentRepository studentRepository;
	
	public StudentController(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	//getmethod
	@RequestMapping("/students")
	public ResponseEntity<?> GetStrudents(){
		return ResponseEntity.ok(studentRepository.findAll());
	}
	//post method
	
	@RequestMapping(value ="/students",method = RequestMethod.POST)
	public ResponseEntity<?> createstudents (@RequestBody Student stu){
		System.out.println(stu);
		Student student = studentRepository.save(stu);
		return ResponseEntity.ok(student);
		
	}
	

}
