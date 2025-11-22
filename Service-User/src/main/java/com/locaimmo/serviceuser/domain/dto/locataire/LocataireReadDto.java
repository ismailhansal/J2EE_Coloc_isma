package com.locaimmo.serviceuser.domain.dto.locataire;

import com.locaimmo.serviceuser.domain.dto.role.RoleDto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.locaimmo.serviceuser.domain.entity.Locataire}
 */
public class LocataireReadDto implements Serializable {
    private final Long id;
    private final String email;
    private final String nom;
    private final String prenom;
    private final String telephone;
    private final Set<RoleDto> roles;
    private final Integer age;
    private final String profession;
    private final String preferences;

    public LocataireReadDto(Long id, String email, String nom, String prenom, String telephone, Set<RoleDto> roles, Integer age, String profession, String preferences) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.roles = roles;
        this.age = age;
        this.profession = profession;
        this.preferences = preferences;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public Integer getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public String getPreferences() {
        return preferences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocataireReadDto entity = (LocataireReadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.prenom, entity.prenom) &&
                Objects.equals(this.telephone, entity.telephone) &&
                Objects.equals(this.roles, entity.roles) &&
                Objects.equals(this.age, entity.age) &&
                Objects.equals(this.profession, entity.profession) &&
                Objects.equals(this.preferences, entity.preferences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, nom, prenom, telephone, roles, age, profession, preferences);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "email = " + email + ", " +
                "nom = " + nom + ", " +
                "prenom = " + prenom + ", " +
                "telephone = " + telephone + ", " +
                "roles = " + roles + ", " +
                "age = " + age + ", " +
                "profession = " + profession + ", " +
                "preferences = " + preferences + ")";
    }
}