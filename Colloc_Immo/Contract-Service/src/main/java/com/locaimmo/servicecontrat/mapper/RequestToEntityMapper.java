package com.locaimmo.servicecontrat.mapper;
import com.locaimmo.servicecontrat.domain.dto.contract.ContractRequestDto;
import com.locaimmo.servicecontrat.domain.dto.deposit.DepositReturnRequestDto;
import com.locaimmo.servicecontrat.domain.dto.rent.RentPaymentRequestDto;
import com.locaimmo.servicecontrat.domain.dto.tenant.TenantRegistrationDto;
import com.locaimmo.servicecontrat.domain.entity.*;
import org.springframework.stereotype.Component;

/**
 * Maps Request DTOs to Entities
 * Used for CREATE operations
 */
@Component
public class RequestToEntityMapper {

    // Contract Request -> Contract Entity
    public Contract toContractEntity(ContractRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Contract entity = new Contract();
        entity.setPropertyId(dto.getPropertyId());
        entity.setTenantId(dto.getTenantId());
        entity.setProprietaireId(dto.getProprietaireId());
        entity.setDateDebut(dto.getDateDebut());
        entity.setDateFin(dto.getDateFin());
        entity.setLoyerMensuel(dto.getLoyerMensuel());
        entity.setDepotGarantie(dto.getDepotGarantie());
        entity.setStatut(Contract.ContractStatus.EN_ATTENTE);
        entity.setConditions(dto.getConditions());

        return entity;
    }

    // Tenant Registration -> Tenant Entity
    public Tenant toTenantEntity(TenantRegistrationDto dto) {
        if (dto == null) {
            return null;
        }

        Tenant entity = new Tenant();
        entity.setUserId(dto.getUserId());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setEmail(dto.getEmail());
        entity.setTelephone(dto.getTelephone());
        entity.setDateNaissance(dto.getDateNaissance());
        entity.setProfession(dto.getProfession());
        entity.setRevenuMensuel(dto.getRevenuMensuel());
        entity.setDocumentIdentite(dto.getDocumentIdentite());

        return entity;
    }

    // Rent Payment Request -> Update Rent Entity
    public void updateRentFromPayment(RentPaymentRequestDto dto, Rent entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setDatePaiement(dto.getDatePaiement());
        entity.setStatutPaiement(Rent.PaymentStatus.PAYE);
        entity.setModePaiement(dto.getModePaiement());
        entity.setReference(dto.getReference());
    }

    // Deposit Return Request -> Update Deposit Entity
    public void updateDepositFromReturn(DepositReturnRequestDto dto, Deposit entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setDateRestitution(dto.getDateRestitution());
        entity.setMontantRetenu(dto.getMontantRetenu());
        entity.setMotifRetenue(dto.getMotifRetenue());

        if (dto.getMontantRetenu().compareTo(java.math.BigDecimal.ZERO) == 0) {
            entity.setStatut(Deposit.DepositStatus.RESTITUE);
        } else {
            entity.setStatut(Deposit.DepositStatus.RETENU_PARTIELLEMENT);
        }
    }
}
