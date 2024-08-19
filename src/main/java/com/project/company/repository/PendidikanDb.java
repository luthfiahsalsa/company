package com.project.company.repository;

import com.project.company.model.BiodataModel;
import com.project.company.model.PendidikanTerakhirModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendidikanDb extends JpaRepository<PendidikanTerakhirModel, Integer> {
    PendidikanTerakhirModel findPendidikanTerakhirModelById(Integer id);
}
