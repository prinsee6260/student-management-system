package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Teacher;

@RestController
public class TeacherController {
	@RequestMapping("/teachers")
	public List<Teacher> GetTeacher(){
		List <Teacher>teachers = new ArrayList();
		teachers.add(new Teacher("vaibhav",23,"java"));
		return teachers;
		
	}

}
