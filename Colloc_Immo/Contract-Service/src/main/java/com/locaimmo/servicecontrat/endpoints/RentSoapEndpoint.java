package com.locaimmo.servicecontrat.endpoints;

import com.locaimmo.rent.*;
import com.locaimmo.servicecontrat.domain.entity.Rent;
import com.locaimmo.servicecontrat.service.IServiceRent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;

@Endpoint
public class RentSoapEndpoint {

    private static final String NAMESPACE_URI = "http://locaimmo.com/rent";

    private final IServiceRent serviceRent;

    @Autowired
    public RentSoapEndpoint(IServiceRent serviceRent) {
        this.serviceRent = serviceRent;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetRentRequest")
    @ResponsePayload
    public GetRentResponse getRent(@RequestPayload GetRentRequest request) {
        GetRentResponse response = new GetRentResponse();
        
        Rent rent = serviceRent.getRentById(request.getId());
        
        if (rent != null) {
            response.setId(rent.getId());
            response.setContractId(rent.getContractId());
            response.setMontant(rent.getMontant());
            response.setStatutPaiement(rent.getStatutPaiement().name());
        } else {
            response.setId(request.getId());
            response.setContractId(0L);
            response.setMontant(BigDecimal.ZERO);
            response.setStatutPaiement("NOT_FOUND");
        }
        
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateRentRequest")
    @ResponsePayload
    public CreateRentResponse createRent(@RequestPayload CreateRentRequest request) {
        CreateRentResponse response = new CreateRentResponse();
        
        Rent rent = new Rent();
        rent.setContractId(request.getContractId());
        rent.setMois(request.getMois());
        rent.setAnnee(request.getAnnee());
        rent.setMontant(request.getMontant());
        rent.setDateEcheance(request.getDateEcheance().toGregorianCalendar().toZonedDateTime().toLocalDate());
        rent.setStatutPaiement(Rent.PaymentStatus.valueOf(request.getStatutPaiement()));
        
        Rent savedRent = serviceRent.saveRent(rent);
        
        response.setId(savedRent.getId());
        response.setMontant(savedRent.getMontant());
        response.setStatutPaiement(savedRent.getStatutPaiement().name());
        response.setMessage("Rent created successfully");
        
        return response;
    }
}

