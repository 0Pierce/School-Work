package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VolService {

    @Autowired
    private VolRepo volunteerRepository;

    public List<Volunteer> getAllVolunteers() {
        return (List<Volunteer>) volunteerRepository.findAll();
    }

    public long countVolunteers() {
        return volunteerRepository.count();
    }

    public void saveVolunteer(Volunteer volunteer) {
    	
    	if(volunteer != null) {
    		volunteerRepository.save(volunteer);
    	}else {
    		System.out.println("Volunteer is null");
    	}
        
    }
}
