package com.example.demo;

import java.time.LocalDate;

public class BloodStock {
    private Long id; 
    private String bloodGroup;
    private int quantity;
    private LocalDate bestBefore; 
    private String status; 

    
    public BloodStock() {}

   
    public BloodStock(Long id, String bloodGroup, int quantity, LocalDate bestBefore, String status) {
        this.id = id;
        this.bloodGroup = bloodGroup;
        this.quantity = quantity;
        this.bestBefore = bestBefore;
        this.status = status;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
