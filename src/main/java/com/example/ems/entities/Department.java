package com.example.ems.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employees")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Integer deptId;
    @Column(name = "dept_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Employee> employees = new HashSet<>();

    public boolean addEmployee(Employee employee){
        if(employees.add(employee))
        {
            employee.setDepartment(this);
            return true;
        }
        return false;
    }

    public boolean removeEmployee(Employee employee){
        if(employees.remove(employee))
        {
            employee.setDepartment(null);
            return true;
        }
        return false;
    }


}

