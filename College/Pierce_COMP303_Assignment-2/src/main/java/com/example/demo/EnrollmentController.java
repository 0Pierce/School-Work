package com.example.demo;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/checkout")
    public String processCheckout(@ModelAttribute("enrollment") Enrollment enrollment) {
        // Ensure the amountPaid is properly set
        if (enrollment.getAmountPaid() == 0) {
            enrollment.setAmountPaid(enrollment.getProgram().getFee()); // Set fee as amountPaid if not set
        }
        
        enrollment.setStartDate(new Date());
        enrollment.setStatus("Paid");
        
        // Save the enrollment
        enrollmentService.saveEnrollment(enrollment);
        
        return "confirmation"; // Redirect to confirmation page
    }

    // Show profile modification form
    @GetMapping("/profile")
    public String showProfileForm(Model model) {
        // Retrieve student information here for the logged-in user
        model.addAttribute("student", new Student()); // Example, replace with actual data
        return "profile";
    }

    // Handle profile modification
    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute("student") Student student) {
        enrollmentService.updateStudentDetails(student);
        return "redirect:/enrollment/profile";
    }
}
