package com.locaimmo.servicecontrat.endpoints;

import com.locaimmo.tenant.*;
import com.locaimmo.servicecontrat.domain.entity.Tenant;
import com.locaimmo.servicecontrat.service.IServiceTenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TenantSoapEndpoint {

    private static final String NAMESPACE_URI = "http://locaimmo.com/tenant";

    private final IServiceTenant serviceTenant;

    @Autowired
    public TenantSoapEndpoint(IServiceTenant serviceTenant) {
        this.serviceTenant = serviceTenant;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTenantRequest")
    @ResponsePayload
    public GetTenantResponse getTenant(@RequestPayload GetTenantRequest request) {
        GetTenantResponse response = new GetTenantResponse();
        
        Tenant tenant = serviceTenant.getTenantById(request.getId());
        
        if (tenant != null) {
            response.setId(tenant.getId());
            response.setNom(tenant.getNom());
            response.setPrenom(tenant.getPrenom());
            response.setEmail(tenant.getEmail());
        } else {
            response.setId(request.getId());
            response.setNom("NOT_FOUND");
            response.setPrenom("");
            response.setEmail("");
        }
        
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateTenantRequest")
    @ResponsePayload
    public CreateTenantResponse createTenant(@RequestPayload CreateTenantRequest request) {
        CreateTenantResponse response = new CreateTenantResponse();
        
        Tenant tenant = new Tenant();
        tenant.setUserId(request.getUserId());
        tenant.setNom(request.getNom());
        tenant.setPrenom(request.getPrenom());
        tenant.setEmail(request.getEmail());
        if (request.getTelephone() != null) {
            tenant.setTelephone(request.getTelephone());
        }
        
        Tenant savedTenant = serviceTenant.saveTenant(tenant);
        
        response.setId(savedTenant.getId());
        response.setNom(savedTenant.getNom());
        response.setPrenom(savedTenant.getPrenom());
        response.setEmail(savedTenant.getEmail());
        response.setMessage("Tenant created successfully");
        
        return response;
    }
}

