package com.locaimmo.servicecontrat.mapper;

import com.locaimmo.servicecontrat.domain.dto.ApplicationSubmittedEventDto;
import com.locaimmo.servicecontrat.domain.dto.contract.ContractSignedEventDto;
import com.locaimmo.servicecontrat.domain.dto.contract.ContractTerminatedEventDto;
import com.locaimmo.servicecontrat.domain.dto.rent.RentPaymentEventDto;
import com.locaimmo.servicecontrat.domain.entity.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Maps Entities to Event DTOs for Kafka publishing
 */
@Component
public class EventMapper {

    // Contract -> ContractSignedEvent
    public ContractSignedEventDto toContractSignedEvent(Contract contract) {
        if (contract == null) {
            return null;
        }

        ContractSignedEventDto event = new ContractSignedEventDto();
        event.setContractId(contract.getId());
        event.setPropertyId(contract.getPropertyId());
        event.setTenantId(contract.getTenantId());
        event.setProprietaireId(contract.getProprietaireId());
        event.setDateDebut(contract.getDateDebut());
        event.setDateFin(contract.getDateFin());
        event.setLoyerMensuel(contract.getLoyerMensuel());
        event.setDepotGarantie(contract.getDepotGarantie());
        event.setSignedAt(LocalDateTime.now());
        event.setEventId(UUID.randomUUID().toString());

        return event;
    }

    // Rent -> RentPaymentEvent
    public RentPaymentEventDto toRentPaymentEvent(Rent rent, Contract contract) {
        if (rent == null) {
            return null;
        }

        RentPaymentEventDto event = new RentPaymentEventDto();
        event.setRentId(rent.getId());
        event.setContractId(rent.getContractId());
        event.setMontant(rent.getMontant());
        event.setDatePaiement(rent.getDatePaiement());
        event.setModePaiement(rent.getModePaiement());
        event.setReference(rent.getReference());
        event.setMois(rent.getMois());
        event.setAnnee(rent.getAnnee());
        event.setEventTime(LocalDateTime.now());
        event.setEventId(UUID.randomUUID().toString());

        if (contract != null) {
            event.setTenantId(contract.getTenantId());
            event.setProprietaireId(contract.getProprietaireId());
        }

        return event;
    }

    // Tenant -> ApplicationSubmittedEvent
    public ApplicationSubmittedEventDto toApplicationSubmittedEvent(
            Tenant tenant, Long propertyId, Long applicationId, String message) {
        if (tenant == null) {
            return null;
        }

        ApplicationSubmittedEventDto event = new ApplicationSubmittedEventDto();
        event.setApplicationId(applicationId);
        event.setPropertyId(propertyId);
        event.setUserId(tenant.getUserId());
        event.setTenantId(tenant.getId());
        event.setTenantNom(tenant.getNom());
        event.setTenantPrenom(tenant.getPrenom());
        event.setTenantEmail(tenant.getEmail());
        event.setRevenuMensuel(tenant.getRevenuMensuel());
        event.setProfession(tenant.getProfession());
        event.setMessageProprietaire(message);
        event.setSubmittedAt(LocalDateTime.now());
        event.setEventId(UUID.randomUUID().toString());

        return event;
    }

    // Contract -> ContractTerminatedEvent
    public ContractTerminatedEventDto toContractTerminatedEvent(
            Contract contract, String reason, Deposit deposit) {
        if (contract == null) {
            return null;
        }

        ContractTerminatedEventDto event = new ContractTerminatedEventDto();
        event.setContractId(contract.getId());
        event.setPropertyId(contract.getPropertyId());
        event.setTenantId(contract.getTenantId());
        event.setProprietaireId(contract.getProprietaireId());
        event.setDateDebut(contract.getDateDebut());
        event.setDateFin(contract.getDateFin());
        event.setDateTermination(java.time.LocalDate.now());
        event.setTerminationReason(reason);
        event.setEventTime(LocalDateTime.now());
        event.setEventId(UUID.randomUUID().toString());

        if (deposit != null) {
            java.math.BigDecimal returned = deposit.getMontant().subtract(
                    deposit.getMontantRetenu() != null ? deposit.getMontantRetenu() : java.math.BigDecimal.ZERO
            );
            event.setDepositReturned(returned);
            event.setDepositRetained(deposit.getMontantRetenu());
        }

        return event;
    }
}