package com.mvcfullcrud.one2many.controllers;

import com.mvcfullcrud.one2many.models.Hall;
import com.mvcfullcrud.one2many.services.HallService;
import com.mvcfullcrud.one2many.services.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class HallController {

    /* ----- Services ----- */
    @Autowired
    private HallService hallService;
    @Autowired
    private UniversityService universityService;

    /* ----- Mapping ----- */
    /* - Render Routes - */
    @GetMapping("/halls")
    public String allHallsPage(Model model) {
        model.addAttribute("allHalls", hallService.findAllHalls());
        return "hallPages/halls";
    }

//    Render FORM PAGE
    @GetMapping("halls/new")
    public String newHallPage(@ModelAttribute("hall")Hall newHall, Model model) {
        model.addAttribute("universities", universityService.findAllUniversities());
        return "hallPages/newHall";
    }

    @GetMapping("/halls/{id}")
    public String viewOneHallPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("thisHall", hallService.findHallById(id));
        return "hallPages/oneHall";
    }

//    Edit Hall
    @GetMapping("/halls/edit")
    public String editHallPage(@RequestParam("id") Long id, Model model) {

        return null;
    }

    /* - Hidden Routes - */
//    Create New hall from FORM PAGE
    @PostMapping("/halls/save") // this path will run behind the scene
    public String addHallToDB(@Valid @ModelAttribute("hall") Hall hall, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("universities", universityService.findAllUniversities());
            return "hallPages/newHall";
        }
        hallService.save(hall);
        return "redirect:/halls";
    }

    @PutMapping("/halls/edit/")
    public String editHallInDB(@RequestParam("id") Long id) {
        return null;
    }

    @GetMapping("/halls/delete")
    public String deleteHall(@RequestParam("id") Long id) {
        return "redirect:/halls";
    }
}
