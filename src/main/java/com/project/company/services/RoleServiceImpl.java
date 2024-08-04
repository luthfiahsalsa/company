package com.project.company.services;

import com.project.company.model.RoleModel;
import com.project.company.repository.RoleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDb roleDb;

    @Override
    public List<RoleModel> getListRole() {
        return roleDb.findAll();
    }

}
