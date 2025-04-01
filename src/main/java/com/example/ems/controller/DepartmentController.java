package com.example.ems.controller;

import com.example.ems.entities.Department;
import com.example.ems.entities.Employee;
import com.example.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments(){
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }


    @PostMapping("/employee/{departmentId}")
    public ResponseEntity<?> addEmployeeInDepartment(@RequestBody Employee employee, @PathVariable int departmentId){
        departmentService.addEmployeeInDepartment(departmentId, employee);
        return ResponseEntity.ok("Saved employee in Dept ID : "+departmentId);
    }



}
