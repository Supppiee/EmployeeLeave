package com.example.demodevika.service;

import com.example.demodevika.entity.Employee;
import com.example.demodevika.repository.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private employeeRepo emps;

    public Employee createEmp(Employee employee) {
        try {
            Employee savedEmployee = emps.save(employee);
            return savedEmployee;
        } catch (Exception e) {
              return null;
        }
    }

    public ResponseEntity<?> getDetail(Long id) { //we are using Optional class to avoid NullPointerException
        try {
            Optional<Employee> emp = emps.findById(id);
            if (emp.isPresent()) {
                return new ResponseEntity<>(emp.get(), HttpStatus.FOUND);
            } else {
                return new ResponseEntity<>("Employee not found"+id, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Error while fetching employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> deleteMyId(Long id) {//we are using Optional class to avoid Nullpointerexception
   try{
       Optional<Employee>emp=emps.findById(id);
       if(emp.isPresent()){
           emps.deleteById(id);
           return new ResponseEntity<>("SUCCESFULLY DELETED " + emp.get().getName(), HttpStatus.OK);

       }
       else {
           return new ResponseEntity<>("employee not found to delete", HttpStatus.NOT_FOUND);
       }
   } catch (Exception e) {
       return new ResponseEntity<>("Error while fetching employee", HttpStatus.INTERNAL_SERVER_ERROR);
   }
    }

    public List<Employee> insertAll(List<Employee> emp) {
        try {
            return emps.saveAll(emp);
        } catch (Exception e) {
            return null;
        }
    }


    public ResponseEntity<?> getAll(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Employee> employeePage = emps.findAll(pageable);
            return new ResponseEntity<>(employeePage, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error while fetching employees", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
