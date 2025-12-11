package com.locaimmo.servicecontrat.service;

import com.locaimmo.servicecontrat.domain.entity.Rent;

public interface IServiceRent {
    Rent getRentById(Long id);
    Rent saveRent(Rent rent);
}

