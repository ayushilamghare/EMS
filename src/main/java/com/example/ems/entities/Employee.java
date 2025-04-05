package com.example.ems.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Integer empId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL, orphanRemoval = true)
    private Address employeeAddress;



    @Override
    public int hashCode() {
        return empId != null ? empId.hashCode() : super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee that = (Employee) obj;
        return empId != null && empId.equals(that.empId);
    }


}
