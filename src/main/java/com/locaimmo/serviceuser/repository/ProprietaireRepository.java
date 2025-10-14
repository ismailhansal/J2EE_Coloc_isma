package com.locaimmo.serviceuser.repository;

import com.locaimmo.serviceuser.domain.entity.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {


  Optional<Proprietaire> findByEmail(String email);


  Optional<Proprietaire> findByNom(String nom);


  Optional<Proprietaire> findByTelephone(String telephone);
}
