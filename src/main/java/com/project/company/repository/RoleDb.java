package com.project.company.repository;

import com.project.company.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDb extends JpaRepository<RoleModel, Integer> {
    RoleModel findByRole(String role);
}
