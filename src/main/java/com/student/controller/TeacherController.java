package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Teacher;

@RestController
public class TeacherController {
	@RequestMapping("/teachers")
	public ResponseEntity<?> GetTeacher() {
		List<Teacher> teachers = new ArrayList();
		teachers.add(new Teacher("vaibhav", 23, "java"));
		return ResponseEntity.ok(teachers);

	}

	@RequestMapping(value = "/teachers",method = RequestMethod.POST)
	public ResponseEntity<?> createteachers(@RequestBody Teacher ter) {
		Teacher teache = new Teacher();
		teache.setAge(ter.getAge());
		teache.setName(ter.getName());
		teache.setSubject(ter.getSubject());
		System.out.println(ter);
		return ResponseEntity.ok(teache);
	}
}