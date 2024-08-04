package com.project.company.repository;

import com.project.company.model.BiodataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiodataDb extends JpaRepository<BiodataModel, Integer> {
    BiodataModel findBiodataModelById(Integer id);
}
