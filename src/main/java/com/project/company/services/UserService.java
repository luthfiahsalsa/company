package com.project.company.services;

import com.project.company.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void addUser(UserModel user);
    UserModel getUserById(Integer id);
    UserModel getUserByEmail(String email);
    String encryptPassword(String password);
    List<UserModel> getListUser();


}
