package com.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentMvcController {
	@RequestMapping("/students/index")
	public String studentsindex () {
	return "student/index";
	}
}
