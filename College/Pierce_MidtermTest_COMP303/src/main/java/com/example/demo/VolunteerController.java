package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
public class VolunteerController {

    private final VolService volService;

    @Autowired
    public VolunteerController(VolService volService) {
        this.volService = volService;
    }

    @GetMapping("/") 
    public String showAllVolunteers(Model model) {
        model.addAttribute("volunteers", volService.getAllVolunteers());
        model.addAttribute("count", volService.countVolunteers());
        return "volunteers"; 
    }
    
    @GetMapping("/volunteers/add") 
    public String addVolunteerForm(Model model) {
        model.addAttribute("volunteer", new Volunteer());
        return "add-vols"; 
    }

    @PostMapping("/volunteers/add") 
    public String addVolunteer(@Valid @ModelAttribute("volunteer") Volunteer volunteer,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-vols"; 
        }
        volService.saveVolunteer(volunteer);
        return "redirect:/";
    }
}
