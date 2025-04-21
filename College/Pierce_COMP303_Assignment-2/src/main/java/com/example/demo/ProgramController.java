package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/programs")
public class ProgramController {
    @Autowired
    private ProgramService programService;

    // Show available programs
    @GetMapping("/select")
    public String showPrograms(Model model) {
        List<Program> programs = programService.getAllPrograms();
        System.out.println("Programs: " + programs); // Log the list of programs
        model.addAttribute("programs", programs);
        return "programSelect";
    }

    @PostMapping("/select")
    public String selectProgram(@RequestParam("programCode") Long programCode, Model model) {
        Program selectedProgram = programService.getProgramById(programCode);
        model.addAttribute("selectedProgram", selectedProgram);
        
        // Set the amountPaid field to the program fee for checkout
        model.addAttribute("amountPaid", selectedProgram.getFee());
        
        return "checkout";
    }
}
