package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;



@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student findByUserNameAndPassword(String userName, String password) {
        return studentRepository.findByUserNameAndPassword(userName, password);
    }

    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}