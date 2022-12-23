package com.student.controller;

import com.student.model.Student;
import com.student.model.Teacher;
import com.student.repository.StudentRepository;
import com.student.repository.TeacherRepository;
import com.student.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private TeacherRepository teacherRepo;

    @GetMapping
    public String login(Model model) {
        model.addAttribute("isFound", true);
        model.addAttribute("loginVo", new LoginVo());
        return "login";
    }


    @PostMapping("/authenticate")
    public String authenticate(Model model, LoginVo loginVo) {
        if (loginVo.getDesg().equalsIgnoreCase("teacher")) {
            Optional<Teacher> teacher
                    = teacherRepo.findByTeacherId(loginVo.getId());
            if (teacher.isPresent()) {
                return "redirect:/students/index";
            }
        } else if (loginVo.getDesg().equalsIgnoreCase("student")) {
            Optional<Student> student
                    = studentRepo.findByRollNumber(loginVo.getId());
            if (student.isPresent()) {
                return "redirect:/students/" + student.get().getId() + "/view";
            }
        }
        model.addAttribute("isFound", false);
        return "login";
    }

}
