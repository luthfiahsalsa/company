package com.project.company.controller;

import com.project.company.services.BiodataService;
import com.project.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/biodata")
public class BiodataController {
    @Autowired
    private BiodataService biodataService;

    @Autowired
    private UserService userService;



}
