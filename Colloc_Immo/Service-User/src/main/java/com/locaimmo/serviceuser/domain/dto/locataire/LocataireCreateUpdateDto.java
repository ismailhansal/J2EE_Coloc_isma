package com.locaimmo.serviceuser.domain.dto.locataire;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.locaimmo.serviceuser.domain.entity.Locataire}
 */
public class LocataireCreateUpdateDto implements Serializable {
    private final String email;
    private final String password;
    private final String nom;
    private final String prenom;
    private final String telephone;
    private final Set<RoleDto1> roles;
    private final Integer age;
    private final String profession;
    private final String preferences;

    public LocataireCreateUpdateDto(String email, String password, String nom, String prenom, String telephone, Instant createdAt, Instant updatedAt, Set<RoleDto1> roles, Integer age, String profession, String preferences) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.roles = roles;
        this.age = age;
        this.profession = profession;
        this.preferences = preferences;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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


    public Set<RoleDto1> getRoles() {
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
        LocataireCreateUpdateDto entity = (LocataireCreateUpdateDto) o;
        return Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
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
        return Objects.hash(email, password, nom, prenom, telephone, roles, age, profession, preferences);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "nom = " + nom + ", " +
                "prenom = " + prenom + ", " +
                "telephone = " + telephone + ", " +
                "roles = " + roles + ", " +
                "age = " + age + ", " +
                "profession = " + profession + ", " +
                "preferences = " + preferences + ")";
    }

    /**
     * DTO for {@link com.locaimmo.serviceuser.domain.entity.Role}
     */
    public static class RoleDto1 implements Serializable {
        private final Long id;
        private final String nom;

        public RoleDto1(Long id, String nom) {
            this.id = id;
            this.nom = nom;
        }

        public Long getId() {
            return id;
        }

        public String getNom() {
            return nom;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RoleDto1 entity = (RoleDto1) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.nom, entity.nom);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, nom);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "nom = " + nom + ")";
        }
    }
}