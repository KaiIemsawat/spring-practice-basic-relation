package com.mvcfullcrud.one2many.controllers;


import com.mvcfullcrud.one2many.models.Hall;
import com.mvcfullcrud.one2many.models.University;
import com.mvcfullcrud.one2many.services.HallService;
import com.mvcfullcrud.one2many.services.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @Autowired
    private HallService hallService;

    @GetMapping("/")
    public String homeRoute() {
        return "redirect:/universities";
    }

    @GetMapping("/universities")
    public String allUniversitiesPage(Model viewModel) {
        viewModel.addAttribute("universities", universityService.findAllUniversities());
        return "universities";
    }

    @GetMapping("/universities/{id}")
    public String oneUniversityPage(Model viewModel, @PathVariable("id") Long id) {
        viewModel.addAttribute("thisUniversity", universityService.findOneUniversityById(id));
        return "oneUniversity";
    }

    @GetMapping("/universities/new")
    public String newUniversity(@ModelAttribute("newUniversity") University thisUniversity) {
        return "newUniversity";
    }

    @PostMapping("/universities/new")
    public String addNewUniversity(
            @Valid @ModelAttribute("newUniversity") University aNewUniversity,
            BindingResult result) {
        if(result.hasErrors()) {
            return "newUniversity";
        }
        universityService.createUniversity(aNewUniversity);
        return "redirect:/universities";
    }

    @GetMapping("/universities/edit") // In the case of @RequestParam, there is no need for '{uid}'
    public String editOneUniversityPage(@RequestParam("uid") Long theId, Model viewModel) {
        viewModel.addAttribute("thisUniversity", universityService.findOneUniversityById(theId));
        return "editUniversity";
    }

    @PostMapping("/universities/edit")
    public String editUniversity(
            @Valid @ModelAttribute("thisUniversity") University updatedUniversity,
            BindingResult result
            ) {
        System.out.println("Inside editUniversity method");

        if(result.hasErrors()) {
            return "editUniversity";
        }
        universityService.updateUniversity(updatedUniversity);
        return "redirect:/universities";
    }

//    @GetMapping("/.../delete") // <-- @GetMapping can use for delete and doesn't need form
//    @DeleteMapping // <-- works with <form>
    @GetMapping("/universities/delete")
//    @DeleteMapping("/universities/delete/{uid}") // <-- if use this, uncomment the tags in editUniversity
    public String delete(@RequestParam("uid") Long theId) {

        universityService.deleteUniversity(theId);
        return "redirect:/universities";
    }

}
