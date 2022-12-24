package com.student.controller;

import com.student.model.Student;
import com.student.model.Teacher;
import com.student.service.LoginService;
import com.student.vo.LoginVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(Model model) {
        model.addAttribute("isFound", true);
        model.addAttribute("loginVo", new LoginVo());
        return "login";
    }


    @PostMapping("/authenticate")
    public String authenticate(Model model, LoginVo loginVo) {
        String res = loginService.authenticate(loginVo,model);
        model.addAttribute("isFound", !"login".equalsIgnoreCase(res));
        return res;
    }

    @GetMapping("/register")
    public String register(Model model, HttpServletRequest request) {
        String page = null;
        String desg = (String) request.getParameter("desg");
        if("teacher".equalsIgnoreCase(desg)){
            page = "redirect:/teacher/form";
        }else if("student".equalsIgnoreCase(desg)){
            page = "redirect:/students/form";
        }else{
            page = "redirect:/students/form";
        }
        return page;
    }

}
