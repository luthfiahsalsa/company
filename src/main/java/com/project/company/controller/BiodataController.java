package com.project.company.controller;

import com.project.company.model.BiodataModel;
import com.project.company.model.PendidikanTerakhirModel;
import com.project.company.model.UserModel;
import com.project.company.repository.PendidikanDb;
import com.project.company.services.BiodataService;
import com.project.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/biodata")
public class BiodataController {
    @Autowired
    private BiodataService biodataService;

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Define the date format pattern
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // Strict date parsing
        // Register custom editor
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping(value ="/addBiodata")
    public String addBiodataFormPage(Model model) {
        UserModel user = userService.getUserByEmail(
                SecurityContextHolder.getContext().getAuthentication().getName()
        );
        if (user.getBiodata() != null) {
            return "redirect:/biodata/view";
        }
        BiodataModel biodata = new BiodataModel();
        PendidikanTerakhirModel pendidikanTerakhirModel = new PendidikanTerakhirModel();
        biodata.setPendidikan(pendidikanTerakhirModel);
        biodata.setUser(user);
        model.addAttribute("biodata", biodata);
        model.addAttribute("user", user);
        return "form-add-biodata";
    }

    @PostMapping(value ="/add")
    public String addBiodataSubmitPage(
            @ModelAttribute BiodataModel biodataModel,
            @ModelAttribute PendidikanTerakhirModel pendidikanTerakhirModel,
            BindingResult bindingResult,
            Model model
    ) {
        UserModel user = userService.getUserByEmail(
                SecurityContextHolder.getContext().getAuthentication().getName()
        );
        biodataService.addBiodata(biodataModel, user, pendidikanTerakhirModel);
//        pendidikanTerakhirModel.setBiodata(biodataModel);
//        biodataModel.setPendidikan(pendidikanTerakhirModel);

        model.addAttribute("nama", biodataModel.getNama());
        return "add-biodata";
    }

    @GetMapping("/viewAll")
    public String viewAllBiodata(
            Model model
    ){
        Boolean pageAllBiodata = true;
        model.addAttribute("pageBiodata",pageAllBiodata);
        model.addAttribute("listBiodata", biodataService.getAllBiodata());
        return "view-all-biodata";
    }

    @GetMapping("/view")
    public String viewBiodata(
            Model model
    ){
        UserModel user = userService.getUserByEmail(
                SecurityContextHolder.getContext().getAuthentication().getName()
        );
        BiodataModel biodataModel = user.getBiodata();
        if(biodataModel==null){
            return "redirect:/biodata/addBiodata";
        }
        Boolean pageBiodata = true;
        model.addAttribute("biodataModel",biodataModel);
        model.addAttribute("pageBiodata",pageBiodata);
        return "view-biodata";
    }

    @GetMapping("/detail")
    public String viewDetailBiodata(
            @RequestParam(value = "idBiodata") Integer idBiodata,
            Model model
    ) {
        BiodataModel biodataModel = biodataService.getBiodataById(idBiodata);
        if (biodataModel == null) {
            return "gagal-view";
        }
        model.addAttribute("biodataModel", biodataModel);
        Boolean pageDetail = true;
        model.addAttribute("pageDetail", pageDetail);
        return "view-biodata";
    }

    @GetMapping("/update")
    public String updateBiodata(
            @RequestParam(value = "idBiodata") Integer idBiodata,
            Model model
    ) {
        BiodataModel biodataModel = biodataService.getBiodataById(idBiodata);
        if (biodataModel == null) {
            return "gagal-ubah";
        }
        model.addAttribute("biodataModel", biodataModel);
        return "form-ubah-biodata";
    }

    @PostMapping("/update")
    public String updateBiodata(@ModelAttribute BiodataModel biodataModel, @ModelAttribute PendidikanTerakhirModel pendidikanTerakhirModel, Model model) {
        BiodataModel updateBiodata = biodataService.updateBiodata(biodataModel, pendidikanTerakhirModel);
        model.addAttribute("biodataModel", updateBiodata);
        return "ubah-biodata";

    }

    @GetMapping("/delete")
    public String deteleBiodata(
            @RequestParam(value = "idBiodata") Integer idBiodata,
            Model model
    ) {
        BiodataModel biodataModel = biodataService.getBiodataById(idBiodata);
        PendidikanTerakhirModel pendidikan = biodataModel.getPendidikan();
        biodataService.deleteBiodata(biodataModel, pendidikan);
        model.addAttribute("biodataModel", biodataModel);
        return "hapus-biodata";
    }

    @RequestMapping("/pelatihan/add")
    public String addRow(
            @RequestParam(value = "nilai", required = true) Integer nilai,
            Model model
    ) {
        model.addAttribute("nilai", nilai);

        return "form-add-biodata";
    }

}
