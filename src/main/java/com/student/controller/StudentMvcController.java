package com.student.controller;

import com.student.model.Marks;
import com.student.model.Teacher;
import com.student.repository.TeacherRepository;
import com.student.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.student.model.Student;
import com.student.repository.StudentRepository;

import java.util.Optional;

@Controller
public class StudentMvcController {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private MarksService marksService;

	@Autowired
	TeacherRepository teacherRepository;

	@RequestMapping("/students/index")
	public String studentsindex(Model model, @RequestParam(required = false) String teacherId) {
		model.addAttribute("students", studentRepository.findAll());
		model.addAttribute("teacherId", teacherId);
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


	@RequestMapping(value = "/students/{Id}/view", method = RequestMethod.GET)
	public String studentsView(@PathVariable int Id, Model model) {
		System.out.println(Id);
		Student student = studentRepository.findById(Id).get();
		model.addAttribute("students", student);
		return "students/view";
	}


	@RequestMapping(value = "/students/{Id}/teachers/{teacherId}/marks", method = RequestMethod.GET)
	public String giveMarks(@PathVariable int Id,@PathVariable int teacherId, Model model) {
		model.addAttribute("studentId",Id);
		model.addAttribute("marks",marksService.getMarksByTeacherId(teacherId));
		return "students/marksForm";
	}

	@RequestMapping(value = "/students/{Id}/marks", method = RequestMethod.POST)
	public String giveMarks(@PathVariable int Id, Marks marks) {
		marksService.giveMarks(Id,marks);
		return "redirect:/students/"+Id+"/view";
	}

}