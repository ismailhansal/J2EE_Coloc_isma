package com.locaimmo.servicecontrat.domain.dto.contract;

import com.locaimmo.servicecontrat.domain.entity.Contract;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractRequestDto {

    @NotNull(message = "Property ID is required")
    private Long propertyId;

    @NotNull(message = "Tenant ID is required")
    private Long tenantId;

    @NotNull(message = "Proprietaire ID is required")
    private Long proprietaireId;

    @NotNull(message = "Date debut is required")
    @FutureOrPresent(message = "Date debut must be present or future")
    private LocalDate dateDebut;

    @NotNull(message = "Date fin is required")
    @Future(message = "Date fin must be in the future")
    private LocalDate dateFin;

    @NotNull(message = "Loyer mensuel is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Loyer mensuel must be positive")
    private BigDecimal loyerMensuel;

    @NotNull(message = "Depot garantie is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Depot garantie must be positive")
    private BigDecimal depotGarantie;

    @Size(max = 5000, message = "Conditions must not exceed 5000 characters")
    private String conditions;

    // Validation method
    @AssertTrue(message = "Date fin must be after date debut")
    public boolean isDateFinAfterDateDebut() {
        if (dateDebut == null || dateFin == null) {
            return true;
        }
        return dateFin.isAfter(dateDebut);
    }
}
