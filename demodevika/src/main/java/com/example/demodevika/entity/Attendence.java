package com.example.demodevika.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Attendence {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    private Long employeeId;

    private LocalDate attendanceDate;

    private LocalTime punchIn;

    private LocalTime punchOut;

    private String status;

}
