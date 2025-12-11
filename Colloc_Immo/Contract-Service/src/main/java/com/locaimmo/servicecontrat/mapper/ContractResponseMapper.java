package com.locaimmo.servicecontrat.mapper;

import com.locaimmo.servicecontrat.domain.dto.contract.ContractResponseDto;
import com.locaimmo.servicecontrat.domain.entity.Contract;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class ContractResponseMapper {

    public ContractResponseDto toResponseDto(Contract entity) {
        if (entity == null) {
            return null;
        }

        ContractResponseDto dto = new ContractResponseDto();
        dto.setId(entity.getId());
        dto.setPropertyId(entity.getPropertyId());
        dto.setTenantId(entity.getTenantId());
        dto.setProprietaireId(entity.getProprietaireId());
        dto.setDateDebut(entity.getDateDebut());
        dto.setDateFin(entity.getDateFin());
        dto.setLoyerMensuel(entity.getLoyerMensuel());
        dto.setDepotGarantie(entity.getDepotGarantie());
        dto.setStatut(entity.getStatut());
        dto.setConditions(entity.getConditions());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        // Computed fields
        dto.setDurationInMonths(calculateDurationInMonths(entity.getDateDebut(), entity.getDateFin()));
        dto.setTotalCost(entity.getLoyerMensuel().multiply(
                java.math.BigDecimal.valueOf(dto.getDurationInMonths())
        ));
        dto.setIsActive(entity.getStatut() == Contract.ContractStatus.ACTIF);
        dto.setDaysRemaining(calculateDaysRemaining(entity.getDateFin()));

        return dto;
    }

    private Long calculateDurationInMonths(LocalDate dateDebut, LocalDate dateFin) {
        if (dateDebut == null || dateFin == null) {
            return 0L;
        }
        return ChronoUnit.MONTHS.between(dateDebut, dateFin);
    }

    private Integer calculateDaysRemaining(LocalDate dateFin) {
        if (dateFin == null) {
            return 0;
        }
        LocalDate today = LocalDate.now();
        if (dateFin.isBefore(today)) {
            return 0;
        }
        return (int) ChronoUnit.DAYS.between(today, dateFin);
    }
}