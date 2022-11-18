package com.student.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Teacher;
import com.student.repository.TeacherRepository;

@RestController
public class TeacherController {
	private TeacherRepository teacherRepository;
	
	
	public TeacherController(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}

	@RequestMapping("/teachers")
	public ResponseEntity<?> GetTeacher() {
		return ResponseEntity.ok(teacherRepository.findAll());

	}

	@RequestMapping(value = "/teachers",method = RequestMethod.POST)
	public ResponseEntity<?> createteachers(@RequestBody Teacher ter) {
		Teacher teache = teacherRepository.save(ter);
		System.out.println(ter);
		return ResponseEntity.ok(teache);
	}
	@RequestMapping(value = "/teachers",method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteteachers(@PathVariable int Id) {
		System.out.println(Id);
		teacherRepository.deleteById(Id);
		return ResponseEntity.ok(Id);
	}
	@RequestMapping(value = "/teachers/{Id}",method = RequestMethod.GET)
	public ResponseEntity<?> findteachers(@PathVariable int Id) {
		System.out.println(Id);
		Optional <Teacher>teache =teacherRepository.findById(Id);
			if(teache.isPresent()) {
				return ResponseEntity.ok(teache.get());
			}else {
				return ResponseEntity.notFound().build();
			}
		}
	
	
}