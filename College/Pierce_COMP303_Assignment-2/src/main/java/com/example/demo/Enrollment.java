package com.example.demo;



import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationNo;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id") // Foreign key column
    private Student student;

    @ManyToOne
    @JoinColumn(name = "program_Code") // Foreign key column
    private Program program;

    @Column(name = "start_Date")
    private Date startDate;

    @Column(name = "amount_Paid")
    private double amountPaid;

    @Column(name = "status")
    private String status;

    // Constructor to ensure student is not null
    public Enrollment(Student student, Program program, Date startDate, double amountPaid, String status) {
        this.student = Objects.requireNonNull(student, "Student cannot be null");
        this.program = program;
        this.startDate = startDate;
        this.amountPaid = amountPaid;
        this.status = status;
    }

    // Getters and setters

    public Long getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(Long applicationNo) {
        this.applicationNo = applicationNo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

