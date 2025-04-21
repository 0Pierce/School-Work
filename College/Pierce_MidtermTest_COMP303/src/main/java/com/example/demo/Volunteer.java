package com.example.demo;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;

@Entity
@Table(name = "Volunteer")
public class Volunteer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID; 

    private String name;

    @Min(value = 6, message = "Age should not be less than 6")
    @Max(value = 10, message = "Age should not exceed 10")
    private int age;

    @Past(message = "Invalid birthday detected")
    private Date dob;

    @Email(message = "Invalid Email detected")
    @Column(unique = true)
    private String email;

    
    
    
    
    // Getters and Setters
    public int getID() { 
        return ID; 
    }

    public void setID(int id) { 
        this.ID = id; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
