package com.locaimmo.serviceuser.repository;

import com.locaimmo.serviceuser.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional findRoleByNom(String nom);
}