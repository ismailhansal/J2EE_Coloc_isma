package com.locaimmo.serviceuser.mapper;

import com.locaimmo.serviceuser.domain.dto.proprietaire.ProprietaireCreateUpdateDto;
import com.locaimmo.serviceuser.domain.dto.proprietaire.ProprietaireReadDto;
import com.locaimmo.serviceuser.domain.entity.Proprietaire;
import org.mapstruct.*;
import java.util.Set;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {RoleMapper.class}
)
public interface ProprietaireMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "roles", ignore = true)
    Proprietaire toEntity(ProprietaireCreateUpdateDto dto);

    @Mapping(target = "roles", source = "roles")
    ProprietaireReadDto toReadDto(Proprietaire proprietaire);

    Set<ProprietaireReadDto> toReadDtoSet(Set<Proprietaire> proprietaires);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "roles", ignore = true)
    Proprietaire partialUpdate(ProprietaireCreateUpdateDto dto, @MappingTarget Proprietaire proprietaire);
}
