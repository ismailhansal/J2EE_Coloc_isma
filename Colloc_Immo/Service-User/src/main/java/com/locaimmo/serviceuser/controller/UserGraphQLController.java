package com.locaimmo.serviceuser.controller;

import com.locaimmo.serviceuser.domain.dto.user.UserCreateUpdateDto;
import com.locaimmo.serviceuser.domain.dto.user.UserInput;
import com.locaimmo.serviceuser.domain.dto.user.UserReadDto;
import com.locaimmo.serviceuser.domain.entity.User;
import com.locaimmo.serviceuser.mapper.UserMapper;
import com.locaimmo.serviceuser.service.IServiceUser;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserGraphQLController {

    private final IServiceUser userService;
    private final UserMapper userMapper;

    public UserGraphQLController(IServiceUser userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @QueryMapping
    public List<UserReadDto> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(userMapper::toUserReadDto)
                .toList();
    }

    @QueryMapping
    public UserReadDto userById(@Argument Long id) {
        return userMapper.toUserReadDto(userService.getUserById(id));
    }


    @MutationMapping
    public UserReadDto createUser(@Argument UserInput input) {

        UserCreateUpdateDto dto = new UserCreateUpdateDto(
                null,                   // id
                input.getEmail(),       // email
                input.getPassword(),    // password
                input.getNom(),         // nom
                input.getPrenom(),      // prenom
                input.getTelephone(),   // telephone
                null                    // roleIds (facultatif pour ton test)
        );


        User saved = userService.create(dto);

        return userMapper.toUserReadDto(saved);
    }


    @MutationMapping
    public UserReadDto updateUser2(
            @Argument Long id,
            @Argument UserInput input
    ) {
        UserCreateUpdateDto dto = new UserCreateUpdateDto(
                id,
                input.getEmail(),
                input.getPassword(),
                input.getNom(),
                input.getPrenom(),
                input.getTelephone(),
                null
        );

        return userMapper.toUserReadDto(userService.updateUser2(id, dto));
    }








}

