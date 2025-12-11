package com.locaimmo.servicecontrat.service.impl;

import com.locaimmo.servicecontrat.domain.entity.Deposit;
import com.locaimmo.servicecontrat.repository.DepositRepository;
import com.locaimmo.servicecontrat.service.IServiceDeposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDepositImpl implements IServiceDeposit {

    private final DepositRepository depositRepository;

    @Autowired
    public ServiceDepositImpl(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    @Override
    public Deposit getDepositById(Long id) {
        return depositRepository.findById(id).orElse(null);
    }

    @Override
    public Deposit saveDeposit(Deposit deposit) {
        return depositRepository.save(deposit);
    }
}

