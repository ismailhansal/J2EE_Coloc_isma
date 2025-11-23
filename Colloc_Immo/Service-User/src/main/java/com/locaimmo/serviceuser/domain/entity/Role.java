package com.locaimmo.serviceuser.domain.entity;

import jakarta.persistence.*;

@Entity
public class Role {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @Column(nullable = false, length = 50,unique = true)
     private String nom;


     public Long getId() {
          return id;
     }
     public void setId(Long id) {
          this.id = id;
     }
     public String getNom() {
          return nom;
     }
     public void setNom(String nom) {
          this.nom = nom;
     }

}
