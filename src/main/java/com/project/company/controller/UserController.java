package com.project.company.controller;

import com.project.company.services.RoleService;
import com.project.company.services.UserService;
import com.project.company.model.UserModel;
import com.project.company.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/addUser")
    public String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/addUser")
    public String addUserSubmitPage(
            @ModelAttribute UserModel user,
            Model model
    ) {
        userService.addUser(user);
        model.addAttribute("email", user.getEmail());
        return "add-user";
    }

    @GetMapping(value = "/loginForm")
    public String loginFormPage(Model model) {
        return "login-form";
    }
}
