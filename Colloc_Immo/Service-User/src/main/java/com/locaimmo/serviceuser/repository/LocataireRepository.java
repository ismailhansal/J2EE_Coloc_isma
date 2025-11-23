package com.locaimmo.serviceuser.repository;

import com.locaimmo.serviceuser.domain.entity.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LocataireRepository extends JpaRepository<Locataire, Long> {


  Optional<Locataire> findByEmail(String email);


  List<Locataire> findByNomContainingIgnoreCase(String nom);
  List<Locataire> findByPrenomContainingIgnoreCase(String prenom);


  List<Locataire> findByAge(Integer age);


  List<Locataire> findByProfessionContainingIgnoreCase(String profession);


  List<Locataire> findByPreferencesContainingIgnoreCase(String preferences);

  Optional<Locataire> findByTelephone(String telephone);
}
