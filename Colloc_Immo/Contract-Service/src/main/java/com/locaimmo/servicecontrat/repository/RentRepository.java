package com.locaimmo.servicecontrat.repository;

import com.locaimmo.servicecontrat.domain.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
}

