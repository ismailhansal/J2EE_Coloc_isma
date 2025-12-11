package com.locaimmo.servicecontrat.mapper;

import com.locaimmo.servicecontrat.domain.dto.contract.ContractDto;
import com.locaimmo.servicecontrat.domain.entity.Contract;
import org.springframework.stereotype.Component;

@Component
public class ContractMapper {

    public ContractDto toDto(Contract entity) {
        if (entity == null) {
            return null;
        }

        ContractDto dto = new ContractDto();
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

        return dto;
    }

    public Contract toEntity(ContractDto dto) {
        if (dto == null) {
            return null;
        }

        Contract entity = new Contract();
        entity.setId(dto.getId());
        entity.setPropertyId(dto.getPropertyId());
        entity.setTenantId(dto.getTenantId());
        entity.setProprietaireId(dto.getProprietaireId());
        entity.setDateDebut(dto.getDateDebut());
        entity.setDateFin(dto.getDateFin());
        entity.setLoyerMensuel(dto.getLoyerMensuel());
        entity.setDepotGarantie(dto.getDepotGarantie());
        entity.setStatut(dto.getStatut());
        entity.setConditions(dto.getConditions());

        return entity;
    }

    public void updateEntityFromDto(ContractDto dto, Contract entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setPropertyId(dto.getPropertyId());
        entity.setTenantId(dto.getTenantId());
        entity.setProprietaireId(dto.getProprietaireId());
        entity.setDateDebut(dto.getDateDebut());
        entity.setDateFin(dto.getDateFin());
        entity.setLoyerMensuel(dto.getLoyerMensuel());
        entity.setDepotGarantie(dto.getDepotGarantie());
        entity.setStatut(dto.getStatut());
        entity.setConditions(dto.getConditions());
    }
}