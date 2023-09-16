package com.mvcfullcrud.one2many.controllers;

import com.mvcfullcrud.one2many.models.Hall;
import com.mvcfullcrud.one2many.services.HallService;
import com.mvcfullcrud.one2many.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String allHallsPage() {
        return null;
    }

//    Render FORM PAGE
    @GetMapping("halls/new")
    public String newHallPage(@ModelAttribute("hall")Hall newHall, Model model) {
        model.addAttribute("universities", universityService.findAllUniversities());
        return "hallPages/newHall";
    }

    @GetMapping("/halls/{id}")
    public String viewOneHallPage(@PathVariable("id") Long id) {
        return null;
    }

//    Edit Hall
    @GetMapping("/halls/edit")
    public String editHallPage(@RequestParam("id") Long id, Model model) {

        return null;
    }

    /* - Hidden Routes - */
//    Create New hall from FORM PAGE
    @PostMapping("/halls/save") // this path will run behind the scene
    public String addHallToDB(@ModelAttribute("hall") Hall hall) {
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
