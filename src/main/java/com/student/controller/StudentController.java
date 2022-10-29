package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
@RestController
public class StudentController {
	//getmethod
	@RequestMapping("/students")
	public ResponseEntity<?> GetStrudents(){
		 List <Student> students = new ArrayList();
		 students.add(new Student("prinsee",1234,3456));
		 students.add(new Student("choti",2345,5674));
			return ResponseEntity.ok(students);
	}
	//post method
	
	@RequestMapping(value ="/students",method = RequestMethod.POST)
	public ResponseEntity<?> createstudents (@RequestBody Student stu){
		Student student = new Student();
		student.setId(stu.getId());
		student.setName(stu.getName());
		student.setRollNumber(stu.getRollNumber());
		System.out.println(stu);
		return ResponseEntity.ok(student);
		
	}
	

}
