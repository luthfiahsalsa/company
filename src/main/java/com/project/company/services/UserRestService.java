package com.project.company.services;

import com.project.company.model.UserModel;

import java.util.List;

public interface UserRestService {
    UserModel createUser(UserModel user);
    List<UserModel> getAllUsers();
}
