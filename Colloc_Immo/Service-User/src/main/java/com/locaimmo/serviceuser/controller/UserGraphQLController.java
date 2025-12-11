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
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.List;

@Controller
public class UserGraphQLController {

    private final IServiceUser userService;
    private final UserMapper userMapper;

    private final Sinks.Many<UserReadDto> userCreatedSink = Sinks.many().multicast().onBackpressureBuffer();
    private final Sinks.Many<UserReadDto> userUpdatedSink = Sinks.many().multicast().onBackpressureBuffer();

    public UserGraphQLController(IServiceUser userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    // ------------------- Subscriptions -------------------
    @SubscriptionMapping
    public Flux<UserReadDto> userCreated() {
        return userCreatedSink.asFlux();
    }

    @SubscriptionMapping
    public Flux<UserReadDto> userUpdated() {
        return userUpdatedSink.asFlux();
    }

    // ------------------- Queries -------------------
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

    // ------------------- Mutations -------------------
    @MutationMapping
    public UserReadDto createUser(@Argument UserInput input) {
        UserCreateUpdateDto dto = new UserCreateUpdateDto(
                null,                   // id
                input.getEmail(),       // email
                input.getPassword(),    // password
                input.getNom(),         // nom
                input.getPrenom(),
                input.getTelephone(),
                null
        );

        User saved = userService.create(dto);
        UserReadDto readDto = userMapper.toUserReadDto(saved);

        userCreatedSink.tryEmitNext(readDto); // <-- publier l'événement pour la subscription
        return readDto;
    }

    @MutationMapping
    public UserReadDto updateUser2(@Argument Long id, @Argument UserInput input) {
        UserCreateUpdateDto dto = new UserCreateUpdateDto(
                id,
                input.getEmail(),
                input.getPassword(),
                input.getNom(),
                input.getPrenom(),
                input.getTelephone(),
                null
        );

        User updated = userService.updateUser2(id, dto);
        UserReadDto readDto = userMapper.toUserReadDto(updated);

        userUpdatedSink.tryEmitNext(readDto); // <-- publier l'événement pour la subscription
        return readDto;
    }

    @MutationMapping
    public User delete(@Argument Long id) {
        return userService.delete(id);
    }
}
