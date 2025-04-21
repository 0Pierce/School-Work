package com.example.demo;

//Pierce
//301247432

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

	
	//Interface used for CRUD operations within MongoDB
    @Autowired
    private MovieRepo movieRepo; 

    //Loads all movies
    @GetMapping("/")
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieRepo.findAll()); 
        model.addAttribute("movie", new Movie()); 
        return "index"; 
    }

  
    //Adds the movies
    @PostMapping("/add")
    public String addMovie(@ModelAttribute Movie movie, Model model) {
        movieRepo.save(movie); 
        model.addAttribute("movies", movieRepo.findAll());
        model.addAttribute("movie", new Movie());
        //Redirects back to index
        return "redirect:/"; 
    }

  
    //Gets the count
    @GetMapping("/count")
    public String countMovies(Model model) {
        long count = movieRepo.count();  
        model.addAttribute("movieCount", count);  
        model.addAttribute("movies", movieRepo.findAll()); 
        return "index"; 
    }

  
    //Deletes movie based on ID
    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable String id) {
        movieRepo.deleteById(id); 
        return "redirect:/"; 
    }
}
