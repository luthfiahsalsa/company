package com.project.company.repository;

import com.project.company.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDb extends JpaRepository<UserModel, Integer> {
    UserModel findByEmail(String email);
}
