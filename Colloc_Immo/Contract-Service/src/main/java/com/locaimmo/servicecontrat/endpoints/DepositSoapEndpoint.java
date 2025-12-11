package com.locaimmo.servicecontrat.endpoints;

import com.locaimmo.deposit.*;
import com.locaimmo.servicecontrat.domain.entity.Deposit;
import com.locaimmo.servicecontrat.service.IServiceDeposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;

@Endpoint
public class DepositSoapEndpoint {

    private static final String NAMESPACE_URI = "http://locaimmo.com/deposit";

    private final IServiceDeposit serviceDeposit;

    @Autowired
    public DepositSoapEndpoint(IServiceDeposit serviceDeposit) {
        this.serviceDeposit = serviceDeposit;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDepositRequest")
    @ResponsePayload
    public GetDepositResponse getDeposit(@RequestPayload GetDepositRequest request) {
        GetDepositResponse response = new GetDepositResponse();
        
        Deposit deposit = serviceDeposit.getDepositById(request.getId());
        
        if (deposit != null) {
            response.setId(deposit.getId());
            response.setContractId(deposit.getContractId());
            response.setMontant(deposit.getMontant());
            response.setStatut(deposit.getStatut().name());
        } else {
            response.setId(request.getId());
            response.setContractId(0L);
            response.setMontant(BigDecimal.ZERO);
            response.setStatut("NOT_FOUND");
        }
        
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateDepositRequest")
    @ResponsePayload
    public CreateDepositResponse createDeposit(@RequestPayload CreateDepositRequest request) {
        CreateDepositResponse response = new CreateDepositResponse();
        
        Deposit deposit = new Deposit();
        deposit.setContractId(request.getContractId());
        deposit.setMontant(request.getMontant());
        deposit.setDateVersement(request.getDateVersement().toGregorianCalendar().toZonedDateTime().toLocalDate());
        deposit.setStatut(Deposit.DepositStatus.valueOf(request.getStatut()));
        
        Deposit savedDeposit = serviceDeposit.saveDeposit(deposit);
        
        response.setId(savedDeposit.getId());
        response.setMontant(savedDeposit.getMontant());
        response.setStatut(savedDeposit.getStatut().name());
        response.setMessage("Deposit created successfully");
        
        return response;
    }
}

