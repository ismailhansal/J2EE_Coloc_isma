package com.locaimmo.servicecontrat.mapper;

import com.locaimmo.servicecontrat.domain.dto.tenant.TenantDto;
import com.locaimmo.servicecontrat.domain.entity.Tenant;
import org.springframework.stereotype.Component;

@Component
public class TenantMapper {

    public TenantDto toDto(Tenant entity) {
        if (entity == null) {
            return null;
        }

        TenantDto dto = new TenantDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setEmail(entity.getEmail());
        dto.setTelephone(entity.getTelephone());
        dto.setDateNaissance(entity.getDateNaissance());
        dto.setProfession(entity.getProfession());
        dto.setRevenuMensuel(entity.getRevenuMensuel());
        dto.setDocumentIdentite(entity.getDocumentIdentite());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public Tenant toEntity(TenantDto dto) {
        if (dto == null) {
            return null;
        }

        Tenant entity = new Tenant();
        entity.setId(dto.getId());
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

    public void updateEntityFromDto(TenantDto dto, Tenant entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setUserId(dto.getUserId());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setEmail(dto.getEmail());
        entity.setTelephone(dto.getTelephone());
        entity.setDateNaissance(dto.getDateNaissance());
        entity.setProfession(dto.getProfession());
        entity.setRevenuMensuel(dto.getRevenuMensuel());
        entity.setDocumentIdentite(dto.getDocumentIdentite());
    }
}