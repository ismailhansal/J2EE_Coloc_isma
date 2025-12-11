package com.locaimmo.servicecontrat.service;

import com.locaimmo.servicecontrat.domain.entity.Deposit;

public interface IServiceDeposit {
    Deposit getDepositById(Long id);
    Deposit saveDeposit(Deposit deposit);
}

