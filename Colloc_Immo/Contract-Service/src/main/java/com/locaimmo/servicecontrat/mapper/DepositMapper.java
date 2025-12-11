package com.locaimmo.servicecontrat.mapper;

import com.locaimmo.servicecontrat.domain.dto.deposit.DepositDto;
import com.locaimmo.servicecontrat.domain.entity.Deposit;
import org.springframework.stereotype.Component;

@Component
public class DepositMapper {

    public DepositDto toDto(Deposit entity) {
        if (entity == null) {
            return null;
        }

        DepositDto dto = new DepositDto();
        dto.setId(entity.getId());
        dto.setContractId(entity.getContractId());
        dto.setMontant(entity.getMontant());
        dto.setDateVersement(entity.getDateVersement());
        dto.setDateRestitution(entity.getDateRestitution());
        dto.setMontantRetenu(entity.getMontantRetenu());
        dto.setStatut(entity.getStatut());
        dto.setMotifRetenue(entity.getMotifRetenue());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public Deposit toEntity(DepositDto dto) {
        if (dto == null) {
            return null;
        }

        Deposit entity = new Deposit();
        entity.setId(dto.getId());
        entity.setContractId(dto.getContractId());
        entity.setMontant(dto.getMontant());
        entity.setDateVersement(dto.getDateVersement());
        entity.setDateRestitution(dto.getDateRestitution());
        entity.setMontantRetenu(dto.getMontantRetenu());
        entity.setStatut(dto.getStatut());
        entity.setMotifRetenue(dto.getMotifRetenue());

        return entity;
    }

    public void updateEntityFromDto(DepositDto dto, Deposit entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setContractId(dto.getContractId());
        entity.setMontant(dto.getMontant());
        entity.setDateVersement(dto.getDateVersement());
        entity.setDateRestitution(dto.getDateRestitution());
        entity.setMontantRetenu(dto.getMontantRetenu());
        entity.setStatut(dto.getStatut());
        entity.setMotifRetenue(dto.getMotifRetenue());
    }
}