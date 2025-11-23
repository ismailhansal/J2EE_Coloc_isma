package com.locaimmo.serviceuser.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PROPRIETAIRE")
public class Proprietaire extends User {
    public Proprietaire() { }

    @Column(length = 100)
    private String adresse;

    // Getters & Setters
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
}
