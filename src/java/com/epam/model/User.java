package com.epam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="FIRSTNAME", nullable=false, unique=false)
    private String firstname;

    @Column(name="LASTNAME", nullable=false, unique=false)
    private String lastname;

    @Column(name="EMAIL", nullable=false, unique=false)
    private String email;
}
