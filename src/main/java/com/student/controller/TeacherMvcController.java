package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.model.Teacher;
import com.student.repository.StudentRepository;
import com.student.repository.TeacherRepository;

@Controller

public class TeacherMvcController {
	@Autowired
	private TeacherRepository teacherrepository;
	@Autowired
	private StudentRepository studenRepository;

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

	@RequestMapping(value = "/teacher/{Id}/delete", method = RequestMethod.GET)
	public String teacherDelete(@PathVariable int Id) {
		teacherrepository.deleteById(Id);
		System.out.println(Id);
		return "redirect:/teacher/index";

	}

	@RequestMapping(value = "/teacher/{Id}/update", method = RequestMethod.GET)
	public String teacherUpdate(@PathVariable int Id, Model model) {
		Teacher teacher = teacherrepository.findById(Id).get();
		model.addAttribute("teacher", teacher);
		System.out.println(Id);
		return "teacher/form";
	}

	@RequestMapping(value = "/teacher/{Id}/Students", method = RequestMethod.GET)
	public String studentshow(Model model, @PathVariable int Id) {
		model.addAttribute("students", studenRepository.findAll());
		model.addAttribute("teacherId", Id);
		return "students/index";
	}

}