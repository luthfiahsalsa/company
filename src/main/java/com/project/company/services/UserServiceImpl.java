package com.project.company.services;

import com.project.company.model.UserModel;
import com.project.company.repository.UserDb;
import com.project.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public void addUser(UserModel user) {
        String password = encryptPassword(user.getPassword());
        user.setPassword(password);
        userDb.save(user);
    }

    @Override
    public String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordHash = passwordEncoder.encode(password);
        return passwordHash;
    }

    @Override
    public UserModel getUserById(Integer id) {
        Optional<UserModel> user = userDb.findById(id);
        if (user.isPresent()){
            return user.get();
        } else {
            return null;
        }
    }

    @Override
    public UserModel getUserByEmail(String email) {
        return userDb.findByEmail(email);
    }

    @Override
    public List<UserModel> getListUser() {
        return userDb.findAll();}
}
