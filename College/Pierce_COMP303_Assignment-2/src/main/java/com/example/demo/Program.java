package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "programs")
public class Program {
	@Id
    @Column(name = "program_Code")  
    private Long programCode;  

    @Column(name = "program_Name") 
    private String programName;

    @Column(name = "duration")  
    private int duration;

    @Column(name = "fee")  
    private double fee;

    // Getters and Setters

    public Long getProgramCode() {
        return programCode;
    }

    public void setProgramCode(Long programCode) {
        this.programCode = programCode;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
