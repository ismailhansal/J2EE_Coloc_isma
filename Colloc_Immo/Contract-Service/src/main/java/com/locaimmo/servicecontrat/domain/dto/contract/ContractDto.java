package com.locaimmo.servicecontrat.domain.dto.contract;

import com.locaimmo.servicecontrat.domain.entity.Contract;
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
public class ContractDto {

    private Long id;

    @NotNull(message = "Property ID is required")
    private Long propertyId;

    @NotNull(message = "Tenant ID is required")
    private Long tenantId;

    @NotNull(message = "Proprietaire ID is required")
    private Long proprietaireId;

    @NotNull(message = "Date debut is required")
    private LocalDate dateDebut;

    @NotNull(message = "Date fin is required")
    private LocalDate dateFin;

    @NotNull(message = "Loyer mensuel is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Loyer mensuel must be positive")
    private BigDecimal loyerMensuel;

    @NotNull(message = "Depot garantie is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Depot garantie must be positive")
    private BigDecimal depotGarantie;

    @NotNull(message = "Statut is required")
    private Contract.ContractStatus statut;

    @Size(max = 5000, message = "Conditions must not exceed 5000 characters")
    private String conditions;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}