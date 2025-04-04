package com.example.ems.service;

import com.example.ems.entities.Department;
import com.example.ems.entities.Employee;
import com.example.ems.exceptions.EmsException;
import com.example.ems.repositories.DepartmentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    /*
        Init Method
     */
    @PostConstruct
    public void init(){
//        this.getDepartmentById(1).getEmployees().size();
    }


    public void addDepartment(Department department){
        departmentRepository.save(department);
    }

    public Department getDepartmentById(int departmentId){
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department does not exist"));
        return department;
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public void addEmployeeInDepartment(int departmentId, Employee employee){
        Department department = this.getDepartmentById(departmentId);
        if(!department.addEmployee(employee))
            throw new EmsException("Employee already exists!");
        departmentRepository.save(department);
    }

}
