package com.locaimmo.servicecontrat.service.impl;

import com.locaimmo.servicecontrat.domain.entity.Tenant;
import com.locaimmo.servicecontrat.repository.TenantRepository;
import com.locaimmo.servicecontrat.service.IServiceTenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTenantImpl implements IServiceTenant {

    private final TenantRepository tenantRepository;

    @Autowired
    public ServiceTenantImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public Tenant getTenantById(Long id) {
        return tenantRepository.findById(id).orElse(null);
    }

    @Override
    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }
}

