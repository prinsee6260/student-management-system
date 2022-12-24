package com.student.service.impl;

import com.student.model.Student;
import com.student.model.Teacher;
import com.student.repository.StudentRepository;
import com.student.repository.TeacherRepository;
import com.student.service.LoginService;
import com.student.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private TeacherRepository teacherRepo;

    @Override
    public String authenticate(LoginVo loginVo, Model model) {
        if (loginVo.getDesg().equalsIgnoreCase("teacher")) {
            Optional<Teacher> teacher
                    = teacherRepo.findByTeacherId(loginVo.getId());
            if (teacher.isPresent()) {
                return "redirect:/students/index?teacherId="+teacher.get().getId();
            }
        } else if (loginVo.getDesg().equalsIgnoreCase("student")) {
            Optional<Student> student
                    = studentRepo.findByRollNumber(loginVo.getId());
            if (student.isPresent()) {
                return "redirect:/students/" + student.get().getId() + "/view";
            }
        }
        return "login";
    }
}
