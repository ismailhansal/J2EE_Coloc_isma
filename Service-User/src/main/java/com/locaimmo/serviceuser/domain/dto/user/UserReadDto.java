package com.locaimmo.serviceuser.domain.dto.user;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.locaimmo.serviceuser.domain.entity.User}
 */
public class UserReadDto implements Serializable {
    private final Long id;
    private final String email;
    private final String password;
    private final String nom;
    private final String prenom;
    private final String telephone;
    private final Set<RoleDto> roles;

    public UserReadDto(Long id, String email, String password, String nom, String prenom, String telephone, Set<RoleDto> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.roles = roles;
    }

    public Long getId() {
        return id;
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

    public Set<RoleDto> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserReadDto entity = (UserReadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.prenom, entity.prenom) &&
                Objects.equals(this.telephone, entity.telephone) &&
                Objects.equals(this.roles, entity.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, nom, prenom, telephone, roles);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "nom = " + nom + ", " +
                "prenom = " + prenom + ", " +
                "telephone = " + telephone + ", " +
                "roles = " + roles + ")";
    }

    /**
     * DTO for {@link com.locaimmo.serviceuser.domain.entity.Role}
     */
    public static class RoleDto implements Serializable {
        private final Long id;
        private final String nom;

        public RoleDto(Long id, String nom) {
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
            RoleDto entity = (RoleDto) o;
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