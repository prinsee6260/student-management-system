package com.student.service;

import com.student.vo.LoginVo;
import org.springframework.ui.Model;

public interface LoginService {
    String authenticate(LoginVo loginVo, Model model);
}
