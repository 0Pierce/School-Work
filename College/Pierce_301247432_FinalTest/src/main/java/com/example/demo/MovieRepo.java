package com.example.demo;

//Pierce
//301247432

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepo extends MongoRepository<Movie, String> {

}
