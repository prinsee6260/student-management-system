package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.model.Student;
import com.student.repository.StudentRepository;

@Controller
public class StudentMvcController {
	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping("/students/index")
	public String studentsindex(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		return "students/index";
	}

	@RequestMapping("/students/form")
	public String studentsform(Model model) {
		model.addAttribute("students", new Student());
		return "students/form";
	}

	@RequestMapping(value = "/students/create", method = RequestMethod.POST)
	public String studentsindex(@ModelAttribute Student stu) {
		System.out.println(stu);
		studentRepository.save(stu);
		return "redirect:/students/index";

	}

	@RequestMapping(value = "/students/{Id}/delete", method = RequestMethod.GET)
	public String studentsDelete(@PathVariable int Id) {
		System.out.println(Id);
		studentRepository.deleteById(Id);
		return "redirect:/students/index";
	}

	@RequestMapping(value = "/students/{Id}/update", method = RequestMethod.GET)
	public String studentsUpdate(@PathVariable int Id, Model model) {
		System.out.println(Id);
		Student student = studentRepository.findById(Id).get();
		model.addAttribute("students", student);
		return "students/form";

	}
}