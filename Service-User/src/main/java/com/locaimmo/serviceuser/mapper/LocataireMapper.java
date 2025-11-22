package com.locaimmo.serviceuser.mapper;

import com.locaimmo.serviceuser.domain.dto.locataire.LocataireCreateUpdateDto;
import com.locaimmo.serviceuser.domain.dto.locataire.LocataireReadDto;
import com.locaimmo.serviceuser.domain.entity.Locataire;
import org.mapstruct.*;
import java.util.Set;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {RoleMapper.class}
)
public interface LocataireMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "roles", ignore = true)
    Locataire toEntity(LocataireCreateUpdateDto dto);

    @Mapping(target = "roles", source = "roles")
    LocataireReadDto toReadDto(Locataire locataire);

    Set<LocataireReadDto> toReadDtoSet(Set<Locataire> locataires);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "roles", ignore = true)
    Locataire partialUpdate(LocataireCreateUpdateDto dto, @MappingTarget Locataire locataire);
}
