package com.example.ems.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @OneToOne
    @JoinColumn(name = "addrId")
    @MapsId
    private Employee employee;


    private String flatNo;
    private String street;
    private String city;
    private String state;

}
