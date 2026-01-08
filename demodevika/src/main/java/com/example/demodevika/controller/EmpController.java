package com.example.demodevika.controller;

import com.example.demodevika.entity.Employee;
import com.example.demodevika.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping ("/employees")
    public Employee createEmployee(@RequestBody  Employee employee) {
        return employeeService.createEmp(employee);
    }

    @PostMapping("/all")
    public List<Employee> insertAll(@RequestBody List<Employee> emp) {
        return employeeService.insertAll(emp);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getDetail(@PathVariable Long id) {
//        return employeeService.getDetail(id);
//    }
@GetMapping("/gall")
public ResponseEntity<?> getAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
) {
    return employeeService.getAll(page, size);
}

//    @GetMapping("/gall")
//    public ResponseEntity<?>getAll(){
//        return employeeService.getAll();
//    }
 @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMyId(@PathVariable Long id){
        return  employeeService.deleteMyId(id);
 }



}
