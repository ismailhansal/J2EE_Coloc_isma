package com.locaimmo.servicecontrat.domain.dto.tenant;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantRegistrationDto {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Nom is required")
    @Size(min = 2, max = 100, message = "Nom must be between 2 and 100 characters")
    private String nom;

    @NotBlank(message = "Prenom is required")
    @Size(min = 2, max = 100, message = "Prenom must be between 2 and 100 characters")
    private String prenom;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Telephone is required")
    @Pattern(regexp = "^[0-9+\\-\\s()]*$", message = "Invalid phone number format")
    @Size(max = 20, message = "Telephone must not exceed 20 characters")
    private String telephone;

    @NotNull(message = "Date de naissance is required")
    @Past(message = "Date de naissance must be in the past")
    private LocalDate dateNaissance;

    @NotBlank(message = "Profession is required")
    @Size(max = 100, message = "Profession must not exceed 100 characters")
    private String profession;

    @NotNull(message = "Revenu mensuel is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Revenu mensuel must be positive")
    private BigDecimal revenuMensuel;

    @NotBlank(message = "Document identite is required")
    private String documentIdentite;

    // Additional fields for application
    @Size(max = 1000, message = "Message must not exceed 1000 characters")
    private String messageProprietaire;

    private Boolean acceptTerms;

    @AssertTrue(message = "You must accept the terms and conditions")
    public boolean isAcceptTerms() {
        return Boolean.TRUE.equals(acceptTerms);
    }
}