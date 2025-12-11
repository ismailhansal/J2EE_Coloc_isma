package com.locaimmo.servicecontrat.service;

import com.locaimmo.servicecontrat.domain.entity.Contract;

public interface IServiceContract {
    Contract getContractById(Long id);
    Contract saveContract(Contract contract);
}

