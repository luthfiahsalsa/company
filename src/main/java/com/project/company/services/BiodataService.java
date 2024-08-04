package com.project.company.services;

import com.project.company.model.BiodataModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BiodataService {
    void addBiodata(BiodataModel biodata);
    BiodataModel updateBiodata(BiodataModel biodata);
    void deleteBiodata(BiodataModel biodata);
    BiodataModel getBiodataById(int id);
    List<BiodataModel> getAllBiodata();
}
