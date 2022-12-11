package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.model.Teacher;
import com.student.repository.TeacherRepository;

@Controller

public class TeacherMvcController {
	@Autowired
	private TeacherRepository teacherrepository;

	@RequestMapping("/teacher/index")
	public String teacherindex(Model model) {
		model.addAttribute("teacher", teacherrepository.findAll());
		return "teacher/index";

	}

	@RequestMapping("/teacher/form")
	public String teacherform(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "teacher/form";

	}

	@RequestMapping(value = "/teacher/create", method = RequestMethod.POST)
	public String teacherindex(@ModelAttribute Teacher tea) {
		teacherrepository.save(tea);
		System.out.println(tea);
		return "redirect:/teacher/index";

	}

	@RequestMapping(value = "/teacher/create", method = RequestMethod.GET)
	public String teacherindex(@PathVariable int Id) {
		teacherrepository.deleteById(Id);
		System.out.println(Id);
		return " redirect:/teacher/index";

	}
}