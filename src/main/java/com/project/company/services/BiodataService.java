package com.project.company.services;

import com.project.company.model.BiodataModel;
import com.project.company.model.PendidikanTerakhirModel;
import com.project.company.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BiodataService {
    void addBiodata(BiodataModel biodata, UserModel user, PendidikanTerakhirModel pendidikan);
    BiodataModel updateBiodata(BiodataModel biodata, PendidikanTerakhirModel pendidikanTerakhirModel);
    void deleteBiodata(BiodataModel biodata, PendidikanTerakhirModel pendidikanTerakhirModel);
    BiodataModel getBiodataById(int id);
    List<BiodataModel> getAllBiodata();
}
