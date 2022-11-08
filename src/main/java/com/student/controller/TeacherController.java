package com.student.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
}