package com.locaimmo.serviceuser.controller;

import com.locaimmo.serviceuser.domain.dto.user.UserCreateUpdateDto;
import com.locaimmo.serviceuser.domain.dto.user.UserReadDto;
import com.locaimmo.serviceuser.domain.entity.User;
import com.locaimmo.serviceuser.mapper.UserMapper;
import com.locaimmo.serviceuser.service.IServiceUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IServiceUser serviceUser;
    private final UserMapper userMapper;

    public UserController(IServiceUser serviceUser, UserMapper userMapper) {
        this.serviceUser = serviceUser;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserReadDto>> getAllUsers() {
        var usersDto = serviceUser.getAllUsers()
                .stream()
                .map(userMapper::toUserReadDto)
                .toList();
        return ResponseEntity.ok(usersDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReadDto> getUserById(@PathVariable Long id) {
        User user = serviceUser.getUserById(id);
        return ResponseEntity.ok(userMapper.toUserReadDto(user));
    }

    @PostMapping
    public ResponseEntity<UserReadDto> createUser(@RequestBody UserCreateUpdateDto dto) {
        User user = userMapper.toEntity(dto);
        User saved = serviceUser.createUser(user);
        return ResponseEntity
                .created(URI.create("/users/" + saved.getId()))
                .body(userMapper.toUserReadDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReadDto> updateUser(@PathVariable Long id,
                                                  @RequestBody UserCreateUpdateDto dto) {
        User user = userMapper.toEntity(dto);
        User updated = serviceUser.updateUser(id, user);
        return ResponseEntity.ok(userMapper.toUserReadDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        serviceUser.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
