package com.locaimmo.serviceuser.service;

import com.locaimmo.serviceuser.domain.entity.Role;

import java.util.List;

public interface IServiceRole {
    Role createRole(Role role);
    Role getRoleById(Long id);
    List<Role> getAllRoles();
    Role updateRole(Role role);
    void deleteRole(Long id);
}
