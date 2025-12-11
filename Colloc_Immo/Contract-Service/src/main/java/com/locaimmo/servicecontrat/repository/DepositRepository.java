package com.locaimmo.servicecontrat.repository;

import com.locaimmo.servicecontrat.domain.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
}

