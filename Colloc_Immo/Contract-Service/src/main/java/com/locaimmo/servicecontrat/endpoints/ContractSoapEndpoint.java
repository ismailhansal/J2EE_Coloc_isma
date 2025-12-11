package com.locaimmo.servicecontrat.endpoints;

import com.locaimmo.contract.*;
import com.locaimmo.servicecontrat.domain.entity.Contract;
import com.locaimmo.servicecontrat.service.IServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;
import java.time.LocalDate;

@Endpoint
public class ContractSoapEndpoint {

    private static final String NAMESPACE_URI = "http://locaimmo.com/contract";

    private final IServiceContract serviceContract;

    @Autowired
    public ContractSoapEndpoint(IServiceContract serviceContract) {
        this.serviceContract = serviceContract;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetContractRequest")
    @ResponsePayload
    public GetContractResponse getContract(@RequestPayload GetContractRequest request) {
        GetContractResponse response = new GetContractResponse();
        
        Contract contract = serviceContract.getContractById(request.getId());
        
        if (contract != null) {
            response.setId(contract.getId());
            response.setStatut(contract.getStatut().name());
            response.setLoyerMensuel(contract.getLoyerMensuel());
        } else {
            // Return default values if contract not found
            response.setId(request.getId());
            response.setStatut("NOT_FOUND");
            response.setLoyerMensuel(BigDecimal.ZERO);
        }
        
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateContractRequest")
    @ResponsePayload
    public CreateContractResponse createContract(@RequestPayload CreateContractRequest request) {
        CreateContractResponse response = new CreateContractResponse();
        
        Contract contract = new Contract();
        contract.setPropertyId(request.getPropertyId());
        contract.setTenantId(request.getTenantId());
        contract.setProprietaireId(request.getProprietaireId());
        contract.setDateDebut(request.getDateDebut().toGregorianCalendar().toZonedDateTime().toLocalDate());
        contract.setDateFin(request.getDateFin().toGregorianCalendar().toZonedDateTime().toLocalDate());
        contract.setLoyerMensuel(request.getLoyerMensuel());
        contract.setDepotGarantie(request.getDepotGarantie());
        contract.setStatut(Contract.ContractStatus.valueOf(request.getStatut()));
        if (request.getConditions() != null) {
            contract.setConditions(request.getConditions());
        }
        
        Contract savedContract = serviceContract.saveContract(contract);
        
        response.setId(savedContract.getId());
        response.setStatut(savedContract.getStatut().name());
        response.setLoyerMensuel(savedContract.getLoyerMensuel());
        response.setMessage("Contract created successfully");
        
        return response;
    }
}

