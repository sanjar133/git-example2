package com.clean.code.springbootlessons.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

}
