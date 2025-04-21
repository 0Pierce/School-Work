package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SeekerService {
    private List<Seeker> seekers = new ArrayList<>();

    public List<Seeker> getAllSeekers() {
        return seekers;
    }

    public Seeker addSeeker(Seeker seeker) {
        seekers.add(seeker);
        return seeker;
    }

    public Seeker updateSeeker(Long id, Seeker updatedSeeker) {
        
        return updatedSeeker;
    }

    public void deleteSeeker(Long id) {
        seekers.removeIf(seeker -> seeker.getId().equals(id));
    }
}
