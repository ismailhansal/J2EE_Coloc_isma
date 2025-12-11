package com.locaimmo.servicecontrat.mapper;

import com.locaimmo.servicecontrat.domain.dto.rent.RentDto;
import com.locaimmo.servicecontrat.domain.entity.Rent;
import org.springframework.stereotype.Component;

@Component
public class RentMapper {

    public RentDto toDto(Rent entity) {
        if (entity == null) {
            return null;
        }

        RentDto dto = new RentDto();
        dto.setId(entity.getId());
        dto.setContractId(entity.getContractId());
        dto.setMois(entity.getMois());
        dto.setAnnee(entity.getAnnee());
        dto.setMontant(entity.getMontant());
        dto.setDateEcheance(entity.getDateEcheance());
        dto.setDatePaiement(entity.getDatePaiement());
        dto.setStatutPaiement(entity.getStatutPaiement());
        dto.setModePaiement(entity.getModePaiement());
        dto.setReference(entity.getReference());
        dto.setCreatedAt(entity.getCreatedAt());

        return dto;
    }

    public Rent toEntity(RentDto dto) {
        if (dto == null) {
            return null;
        }

        Rent entity = new Rent();
        entity.setId(dto.getId());
        entity.setContractId(dto.getContractId());
        entity.setMois(dto.getMois());
        entity.setAnnee(dto.getAnnee());
        entity.setMontant(dto.getMontant());
        entity.setDateEcheance(dto.getDateEcheance());
        entity.setDatePaiement(dto.getDatePaiement());
        entity.setStatutPaiement(dto.getStatutPaiement());
        entity.setModePaiement(dto.getModePaiement());
        entity.setReference(dto.getReference());

        return entity;
    }

    public void updateEntityFromDto(RentDto dto, Rent entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setContractId(dto.getContractId());
        entity.setMois(dto.getMois());
        entity.setAnnee(dto.getAnnee());
        entity.setMontant(dto.getMontant());
        entity.setDateEcheance(dto.getDateEcheance());
        entity.setDatePaiement(dto.getDatePaiement());
        entity.setStatutPaiement(dto.getStatutPaiement());
        entity.setModePaiement(dto.getModePaiement());
        entity.setReference(dto.getReference());
    }
}