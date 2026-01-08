package com.example.demodevika.repository;

import com.example.demodevika.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepo extends JpaRepository<Employee, Long> {

}
