package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.repository.StudentRepository;

@Controller
public class StudentMvcController  {
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping("/students/index")
	public String studentsindex (Model model) {
		model.addAttribute("students",studentRepository.findAll());
	return "student/index";
	}
}
