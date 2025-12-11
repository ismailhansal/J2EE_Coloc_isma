package com.locaimmo.servicecontrat.domain.dto.deposit;

import com.locaimmo.servicecontrat.domain.entity.Deposit;
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
public class DepositDto {

    private Long id;

    @NotNull(message = "Contract ID is required")
    private Long contractId;

    @NotNull(message = "Montant is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Montant must be positive")
    private BigDecimal montant;

    @NotNull(message = "Date versement is required")
    private LocalDate dateVersement;

    private LocalDate dateRestitution;

    @DecimalMin(value = "0.0", message = "Montant retenu must be positive or zero")
    private BigDecimal montantRetenu;

    @NotNull(message = "Statut is required")
    private Deposit.DepositStatus statut;

    @Size(max = 5000, message = "Motif retenue must not exceed 5000 characters")
    private String motifRetenue;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}