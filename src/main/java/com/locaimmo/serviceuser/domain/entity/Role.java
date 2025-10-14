package com.locaimmo.serviceuser.domain.entity;

import jakarta.persistence.*;

@Entity
public class Role {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @Column(nullable = false, length = 50,unique = true)
     private String nom;

}
