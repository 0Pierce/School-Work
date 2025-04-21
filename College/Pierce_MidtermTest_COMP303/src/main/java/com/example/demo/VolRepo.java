package com.example.demo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface VolRepo extends CrudRepository<Volunteer, Integer> {
	
	Optional<Volunteer> findByName(String name);
	void deleteById(int ID);
	
	
}
