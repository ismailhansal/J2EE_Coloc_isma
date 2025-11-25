package com.example.serviceproperty.locaimmo.serviceproperty.controller;

import com.example.serviceproperty.locaimmo.serviceproperty.domain.dto.PropertyDto;
import com.example.serviceproperty.locaimmo.serviceproperty.domain.entity.Property;
import com.example.serviceproperty.locaimmo.serviceproperty.mapper.PropertyMapper;
import com.example.serviceproperty.locaimmo.serviceproperty.service.IServiceProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final IServiceProperty serviceProperty;
    private final PropertyMapper propertyMapper;

    public PropertyController(IServiceProperty serviceProperty, PropertyMapper propertyMapper) {
        this.serviceProperty = serviceProperty;
        this.propertyMapper = propertyMapper;
    }

    @GetMapping
    public ResponseEntity<List<PropertyDto>> getAllProperties() {
        List<PropertyDto> dtos = serviceProperty.findAll()
                .stream()
                .map(propertyMapper::toDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDto> getPropertyById(@PathVariable Long id) {
        Property property = serviceProperty.findById(id);
        return ResponseEntity.ok(propertyMapper.toDto(property));
    }

    @GetMapping("/{id}/full")
    public ResponseEntity<PropertyDto> getPropertyWithUser(@PathVariable Long id) {
        PropertyDto dto = serviceProperty.getPropertyWithUser(id);
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto dto) {
        Property property = propertyMapper.toEntity(dto);
        Property saved = serviceProperty.create(property);
        return ResponseEntity
                .created(URI.create("/properties/" + saved.getId()))
                .body(propertyMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyDto> updateProperty(@PathVariable Long id,
                                                          @RequestBody PropertyDto dto) {
        Property property = propertyMapper.toEntity(dto);
        Property updated = serviceProperty.update(id, property);
        return ResponseEntity.ok(propertyMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        serviceProperty.delete(id);
        return ResponseEntity.noContent().build();
    }
}
