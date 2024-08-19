package com.project.company.controller;

import ch.qos.logback.core.model.Model;
import com.project.company.model.UserModel;
import com.project.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    private String home(Model model) {
        return "home";
    }


}
