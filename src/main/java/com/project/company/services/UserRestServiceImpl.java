package com.project.company.services;

import com.project.company.model.UserModel;
import com.project.company.repository.UserDb;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserRestServiceImpl implements UserRestService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel createUser(UserModel user) {
        return userDb.save(user);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userDb.findAll();
    }

}
