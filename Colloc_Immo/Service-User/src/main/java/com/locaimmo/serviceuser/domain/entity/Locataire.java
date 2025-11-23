package com.locaimmo.serviceuser.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("LOCATAIRE")
public class Locataire extends User {
    public Locataire() { }

    @Column
    private Integer age;

    @Column(length = 100)
    private String profession;

    @Column(length = 255)
    private String preferences;

    // Getters & Setters
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }

    public String getPreferences() { return preferences; }
    public void setPreferences(String preferences) { this.preferences = preferences; }
}
