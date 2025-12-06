package com.locaimmo.serviceuser.service.impl;

import com.locaimmo.serviceuser.domain.entity.Role;
import com.locaimmo.serviceuser.domain.entity.User;
import com.locaimmo.serviceuser.repository.RoleRepository;
import com.locaimmo.serviceuser.repository.UserRepository;
import com.locaimmo.serviceuser.service.IServiceUser;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceUserImpl implements IServiceUser {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Autowired
    public ServiceUserImpl(UserRepository userRepository,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DataIntegrityViolationException("Email déjà utilisé: " +
                    user.getEmail());
        } else return userRepository.save(user);
    }
    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new
                EntityNotFoundException("User not found"+id));
    }
    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User updateUser( Long id,User user) {
        User existing = userRepository.findById(user.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found: " +
                        user.getId()));
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setNom(user.getNom());
        existing.setPrenom(user.getPrenom());
        existing.setTelephone(user.getTelephone());
        return userRepository.save(existing);
    }
    @Override

    public void deleteUser(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }else throw new EntityNotFoundException("User not fount"+id);
    }
    @Transactional(readOnly = true)
    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " +
                        email));
        return user;
    }

    @Override
    public User addRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " +
                        userId));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found: " +
                        roleId));
        user.getRoles().add(role);
        return userRepository.save(user);
    }
    @Override
    public User removeRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " +
                        userId));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found: " +
                        roleId));
        user.getRoles().remove(role);
        return userRepository.save(user);
    }
}