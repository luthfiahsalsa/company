package com.project.company.services;

import com.project.company.model.BiodataModel;
import com.project.company.repository.BiodataDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.company.services.BiodataService;

import java.util.List;

@Service
public class BiodataServiceImpl implements BiodataService {
    @Autowired
    private BiodataDb biodataDb;

    @Override
    public void addBiodata(BiodataModel biodata){
        biodataDb.save(biodata);
    }

    @Override
    public BiodataModel updateBiodata(BiodataModel biodata) {
        return biodataDb.save(biodata);
    }

    @Override
    public void deleteBiodata(BiodataModel biodata) {
        biodataDb.delete(biodata);
    }

    @Override
    public BiodataModel getBiodataById(int id) {
        return biodataDb.findById(id).get();
    }

    @Override
    public List<BiodataModel> getAllBiodata() {
        return biodataDb.findAll();
    }
}
