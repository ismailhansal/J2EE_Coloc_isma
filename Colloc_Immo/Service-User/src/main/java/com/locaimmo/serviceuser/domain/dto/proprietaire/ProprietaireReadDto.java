package com.locaimmo.serviceuser.domain.dto.proprietaire;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.locaimmo.serviceuser.domain.entity.Proprietaire}
 */
public class ProprietaireReadDto implements Serializable {
    private final Long id;
    private final String email;
    private final String nom;
    private final String prenom;
    private final String telephone;
    private final Set<RoleDto> roles;
    private final String adresse;

    public ProprietaireReadDto(Long id, String email, String nom, String prenom, String telephone, Set<RoleDto> roles, String adresse) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.roles = roles;
        this.adresse = adresse;
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

    public String getAdresse() {
        return adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProprietaireReadDto entity = (ProprietaireReadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.prenom, entity.prenom) &&
                Objects.equals(this.telephone, entity.telephone) &&
                Objects.equals(this.roles, entity.roles) &&
                Objects.equals(this.adresse, entity.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, nom, prenom, telephone, roles, adresse);
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
                "adresse = " + adresse + ")";
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