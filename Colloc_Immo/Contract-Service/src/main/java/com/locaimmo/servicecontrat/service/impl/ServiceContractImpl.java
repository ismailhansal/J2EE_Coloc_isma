package com.locaimmo.servicecontrat.service.impl;

import com.locaimmo.servicecontrat.domain.entity.Contract;
import com.locaimmo.servicecontrat.repository.ContractRepository;
import com.locaimmo.servicecontrat.service.IServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceContractImpl implements IServiceContract {

    private final ContractRepository contractRepository;

    @Autowired
    public ServiceContractImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }
}

