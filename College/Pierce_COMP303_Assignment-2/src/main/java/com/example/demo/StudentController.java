package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Show registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    // Handle registration
    @PostMapping("/register")
    public String registerStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/login";
    }

    // Show login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginStudent(@RequestParam String userName, 
                               @RequestParam String password, 
                               HttpSession session, 
                               Model model) {
        Student student = studentService.findByUserNameAndPassword(userName, password);
        if (student != null) {
            // Store student info in session
            session.setAttribute("user", student);
            // Redirect to home page (index) after successful login
            return "redirect:/";  
        } else {
            // Add an error message to the model for invalid login
            model.addAttribute("error", "Invalid username or password");
            return "login";  // Stay on login page if login failed
        }
    }
    // Display profile page
    @GetMapping("/profile")
    public String showProfilePage(HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("user");
        if (student == null) {
            return "redirect:/students/login";
        }
        model.addAttribute("student", student);
        return "profile";
    }

    // Handle logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
