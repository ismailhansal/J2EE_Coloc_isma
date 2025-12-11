package com.locaimmo.servicecontrat.service.impl;

import com.locaimmo.servicecontrat.domain.entity.Rent;
import com.locaimmo.servicecontrat.repository.RentRepository;
import com.locaimmo.servicecontrat.service.IServiceRent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRentImpl implements IServiceRent {

    private final RentRepository rentRepository;

    @Autowired
    public ServiceRentImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public Rent getRentById(Long id) {
        return rentRepository.findById(id).orElse(null);
    }

    @Override
    public Rent saveRent(Rent rent) {
        return rentRepository.save(rent);
    }
}

