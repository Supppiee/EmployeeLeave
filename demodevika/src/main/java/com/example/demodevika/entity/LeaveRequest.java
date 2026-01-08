package com.example.demodevika.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveId;

    private Long employeeId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    private String status;

    private LocalDateTime appliedAt;
}
