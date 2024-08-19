package com.project.company.services;

import com.project.company.model.BiodataModel;
import com.project.company.model.PendidikanTerakhirModel;
import com.project.company.model.UserModel;
import com.project.company.repository.BiodataDb;
import com.project.company.repository.PendidikanDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.project.company.services.BiodataService;

import java.util.List;

@Service
public class BiodataServiceImpl implements BiodataService {
    @Autowired
    private BiodataDb biodataDb;

    @Autowired
    private PendidikanDb pendidikanDb;

    @Override
    public void addBiodata(BiodataModel biodata, UserModel user, PendidikanTerakhirModel pendidikan){
        user.setBiodata(biodata);
        biodata.setPendidikan(pendidikan);
        pendidikan.setBiodata(biodata);
        pendidikanDb.save(pendidikan);
        biodataDb.save(biodata);
    }

    @Override
    public BiodataModel updateBiodata(BiodataModel biodata, PendidikanTerakhirModel pendidikanTerakhirModel) {
        pendidikanDb.save(pendidikanTerakhirModel);
        return biodataDb.save(biodata);
    }

    @Override
    public void deleteBiodata(BiodataModel biodata, PendidikanTerakhirModel pendidikanTerakhirModel) {
        pendidikanDb.delete(pendidikanTerakhirModel);
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
