package com.locaimmo.servicecontrat.service;

import com.locaimmo.servicecontrat.domain.entity.Tenant;

public interface IServiceTenant {
    Tenant getTenantById(Long id);
    Tenant saveTenant(Tenant tenant);
}

