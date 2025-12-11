package com.locaimmo.servicecontrat.domain.dto.tenant;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantDto {

    private Long id;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Nom is required")
    @Size(max = 100, message = "Nom must not exceed 100 characters")
    private String nom;

    @NotBlank(message = "Prenom is required")
    @Size(max = 100, message = "Prenom must not exceed 100 characters")
    private String prenom;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @Pattern(regexp = "^[0-9+\\-\\s()]*$", message = "Invalid phone number format")
    @Size(max = 20, message = "Telephone must not exceed 20 characters")
    private String telephone;

    @Past(message = "Date de naissance must be in the past")
    private LocalDate dateNaissance;

    @Size(max = 100, message = "Profession must not exceed 100 characters")
    private String profession;

    @DecimalMin(value = "0.0", inclusive = false, message = "Revenu mensuel must be positive")
    private BigDecimal revenuMensuel;

    private String documentIdentite;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}