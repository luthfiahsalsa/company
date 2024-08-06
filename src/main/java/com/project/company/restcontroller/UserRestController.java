package com.project.company.restcontroller;

import com.project.company.model.UserModel;
import com.project.company.services.UserRestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {
    @Autowired
    private UserRestService userRestService;

    @PostMapping("/userCreate")
    private UserModel createUser(@Valid @RequestBody UserModel userModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Request Body has invalid type or missing field"
            );
        } else {
            return userRestService.createUser(userModel);
        }

    }


}
