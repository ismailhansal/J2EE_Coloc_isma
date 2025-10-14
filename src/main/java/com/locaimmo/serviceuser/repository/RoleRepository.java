package com.locaimmo.serviceuser.repository;

import com.locaimmo.serviceuser.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional findRoleByNom(String nom);
}