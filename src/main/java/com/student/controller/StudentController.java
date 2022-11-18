package com.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.repository.StudentRepository;
@RestController
public class StudentController {
	private StudentRepository studentRepository;
	// depency injection jn hmlg ko koe object apne class use
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
	@RequestMapping(value="/students/{Id}",method =RequestMethod.DELETE)
    public ResponseEntity<?> deletstudents(@PathVariable int Id){
		System.out.println(Id);
		 studentRepository.deleteById(Id);
		return ResponseEntity.ok().build();
	}
	//id do to student milta hai
	@RequestMapping(value="/students/{Id}",method =RequestMethod.GET)
    public ResponseEntity<?> findstudents(@PathVariable int Id){
		System.out.println(Id);
		 Optional<Student> student = studentRepository.findById(Id);
		 if(student.isPresent())
		 return ResponseEntity.ok(student.get());
		 else {
			 return ResponseEntity.notFound().build();
		 }
	}
}
