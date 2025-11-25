package com.example.serviceproperty.locaimmo.serviceproperty.feignrequests;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-user",contextId = "userFeignRequest")
public interface UserFeignRequest {
    @GetMapping("/users/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id);
}
