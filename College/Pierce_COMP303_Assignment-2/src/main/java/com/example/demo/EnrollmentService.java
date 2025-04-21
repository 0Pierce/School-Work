package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Save an enrollment (for checkout/payment processing)
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    // Update student details (profile modification)
    public void updateStudentDetails(Student student) {
        Optional<Student> existingStudent = studentRepository.findById(student.getStudentId());
        if (existingStudent.isPresent()) {
            Student updatedStudent = existingStudent.get();
            updatedStudent.setAddress(student.getAddress());
            updatedStudent.setCity(student.getCity());
            updatedStudent.setPostalCode(student.getPostalCode());
            studentRepository.save(updatedStudent);
        }
    }

    // Other methods as needed
}
