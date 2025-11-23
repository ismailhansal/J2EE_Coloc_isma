package com.locaimmo.serviceuser.mapper;

import com.locaimmo.serviceuser.domain.dto.role.RoleDto;
import com.locaimmo.serviceuser.domain.entity.Role;
import org.mapstruct.*;

import java.util.Set;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    Role toEntity(RoleDto roleDto);
    RoleDto toDto(Role role);
    Set<RoleDto> toDtoSet(Set<Role> role);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role partialUpdate(RoleDto roleDto, @MappingTarget Role role);
}