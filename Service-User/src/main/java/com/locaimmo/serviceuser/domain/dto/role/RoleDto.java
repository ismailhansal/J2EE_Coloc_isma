package com.locaimmo.serviceuser.domain.dto.role;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.locaimmo.serviceuser.domain.entity.Role}
 */
public class RoleDto implements Serializable {
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